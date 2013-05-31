package au.com.optus.service.tcs.wurfl.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import au.com.optus.service.tcs.wurfl.jpa.dao.DeviceDao;
import au.com.optus.service.tcs.wurfl.jpa.domain.Device;
import au.com.optus.service.tcs.wurfl.jpa.domain.Group;
import au.com.optus.service.tcs.wurfl.jpa.domain.WurflSource;
import au.com.optus.service.tcs.wurfl.repository.DeviceRepository;
import au.com.optus.service.tcs.wurfl.repository.GroupRepository;
import au.com.optus.service.tcs.wurfl.repository.WurflSourceRepository;

@Service
public class WurflDataRefreshService {

	@Autowired
	WurflEntityFactory wurflFactory;

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	GroupRepository groupRepository;

	@Autowired
	WurflSourceRepository wurflSourcerepository;

	@Autowired
	DeviceDao deviceDao;

	public JSONObject xmlToJson(InputStreamReader xmlStream, String sourceName)
			throws IOException, JSONException {
		char[] buf = new char[1024 * 64];

		int cnt = -1;
		StringBuilder optStr = new StringBuilder(1024 * 1024 * 25);
		while ((cnt = xmlStream.read(buf)) > 0) {
			optStr.append(buf, 0, cnt);
		}

		String jsonStr = optStr.toString();
		JSONObject jsonObject = XML.toJSONObject(jsonStr);
		jsonObject.put("sourceName", sourceName);
		return jsonObject;
	}

	public JSONObject xmlToJson(ZipInputStream zipStream, String sourceName)
			throws IOException, JSONException {
		byte[] buf = new byte[1024 * 64];

		String jsonStr = "";
		ByteArrayOutputStream baos = null;
		try {
			try {
				baos = new ByteArrayOutputStream(1024 * 64);

				int cnt = -1;
				while ((cnt = zipStream.read(buf)) > 0) {
					baos.write(buf, 0, cnt);
				}

				jsonStr = new String(baos.toByteArray());
			} finally {
				if (null != baos) {
					baos.close();
				}
			}

		} finally {
			zipStream.close();
		}

		JSONObject jsonObject = XML.toJSONObject(jsonStr);
		jsonObject.put("sourceName", sourceName);
		return jsonObject;
	}

	public JSONArray getJSONDevice(JSONObject jsonWurfl) throws JSONException {
		String sourceName = jsonWurfl.optString("sourceName");
		System.out.println("source name = " + sourceName);
		JSONObject jsonObject = jsonWurfl.optJSONObject("wurfl");
		if (jsonObject == null) {
			jsonObject = jsonWurfl.optJSONObject("wurfl_patch");
		}

		JSONArray jsonDevices = jsonObject.optJSONObject("devices")
				.optJSONArray("device");

		return jsonDevices;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void refreshWurflData(InputStreamReader xmlStream, String sourceName)
			throws IOException, JSONException {
		JSONObject jsonWurfl = this.xmlToJson(xmlStream, sourceName);
		WurflSource ws = wurflFactory.createWurflSource(jsonWurfl);

		ws.setUpdatedTime(Calendar.getInstance());
		wurflSourcerepository.saveAndFlush(ws);

		JSONArray jsonDeviceArray = jsonWurfl.getJSONObject("wurfl").optJSONObject("devices").optJSONArray("device");
		for (int i = 0; i < jsonDeviceArray.length(); i++) {
			JSONObject jsonDevice = jsonDeviceArray.getJSONObject(i);
			Device device = wurflFactory.createDevice(jsonDevice, ws);
			device = deviceRepository.saveAndFlush(device);
			refreshDeviceByGroups(device, jsonDevice);
			//			assert device != null;
		}

	}

	//	@Transactional(propagation=Propagation.REQUIRED)
	public void refreshDeviceByGroups(Device device, JSONObject jsonDevice) throws JSONException {
		if (jsonDevice.has("group")) {
			JSONArray jsonGrps = jsonDevice.optJSONArray("group");
			Device device1 = deviceRepository.findOne(device.getId());
			if (null != jsonGrps) {
				for (int i = 0; i < jsonGrps.length(); i++) {
					JSONObject jsonGroup = jsonGrps.getJSONObject(i);
					Group grp = wurflFactory.createGroup(jsonGroup, device1);
					device1.addGroup(grp);
					grp = groupRepository.saveAndFlush(grp);
					//					device1 = deviceRepository.saveAndFlush(device1);
					System.out.println("grp id = " + grp.getId());
					refreshGroupByCapabilities(grp, jsonGroup);
				}
			} else {
				JSONObject jsonGrp = jsonDevice.getJSONObject("group");
				Group grp = wurflFactory.createGroup(jsonGrp, device);
				Device device2 = deviceRepository.findOne(device.getId());
				device2.addGroup(grp);
				grp.setDevice(device2);
				//device2 = deviceRepository.saveAndFlush(device2);
				grp = groupRepository.saveAndFlush(grp);
				System.out.println("grp id = " + grp.getId());
				refreshGroupByCapabilities(grp, jsonGrp);
				//				Set<Group> groups = device2.getGroups();
				//				for(Group grp1 : groups) {
				//					refreshGroupByCapabilities(grp1, jsonGrp);
				//				}

			}
		}

	}

	//	@Transactional(propagation=Propagation.REQUIRED)
	public void refreshGroupByCapabilities(Group group1, JSONObject jsonGroup) throws JSONException {
		Group group = groupRepository.findOne(group1.getId());
		if (jsonGroup.has("capability")) {
			JSONArray capaArray = jsonGroup.optJSONArray("capability");
			if (null != capaArray) {
				group.setJsonCapabilities(capaArray.toString());

				groupRepository.saveAndFlush(group);

			} else {
				JSONObject jsonCapa = jsonGroup.getJSONObject("capability");
				group.setJsonCapabilities(jsonCapa.toString());
				groupRepository.saveAndFlush(group);
			}

		} else {
			group.setJsonCapabilities("");
			group = groupRepository.saveAndFlush(group);
		}

	}

	public void refreshDeviceGroups(List<Group> groups) {
		groupRepository.save(groups);
		groupRepository.flush();
	}

}
