package au.com.optus.service.tcs.wurfl.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.optus.service.tcs.wurfl.jpa.domain.Device;
import au.com.optus.service.tcs.wurfl.jpa.domain.Group;
import au.com.optus.service.tcs.wurfl.jpa.domain.WurflSource;
import au.com.optus.service.tcs.wurfl.repository.CapabilityRepository;
import au.com.optus.service.tcs.wurfl.repository.DeviceRepository;
import au.com.optus.service.tcs.wurfl.repository.GroupRepository;
import au.com.optus.service.tcs.wurfl.repository.WurflSourceRepository;

@Service
//@Transactional
public class WurflDataRefreshService {

	@Autowired
	WurflEntityFactory wurflFactory;

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	GroupRepository groupRepository;

	@Autowired
	CapabilityRepository capabilityRepository;

	@Autowired
	WurflSourceRepository wurflSourcerepository;

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

	public void refreshWurflData(InputStreamReader xmlStream, String sourceName)
			throws IOException, JSONException {
		JSONObject jsonWurfl = this.xmlToJson(xmlStream, sourceName);
		WurflSource ws = wurflFactory.createWurflSource(jsonWurfl);

		ws.setUpdatedTime(Calendar.getInstance());
		wurflSourcerepository.save(ws);
		wurflSourcerepository.flush();
		System.out.println("ws id = " + ws.getId());

		JSONArray jsonDeviceArray = jsonWurfl.getJSONObject("wurfl").optJSONObject("devices").optJSONArray("device");
		List<Device> devices = new ArrayList<Device>();
		for (int i = 0; i < jsonDeviceArray.length(); i++) {
			Device device = wurflFactory.createDevice(jsonDeviceArray.getJSONObject(i), ws);
			assert device != null;
			devices.add(device);

		}

		deviceRepository.save(devices);
		deviceRepository.flush();

		//		List<Group> groups = new ArrayList<Group> ();
		//		for (Device d1 : devices) {
		//			System.out.println("group size of device: " + d1.getGroups().size());
		//			groups.addAll(d1.getGroups());
		//		}
		//
		//		refreshDeviceGroups(groups);
	}

	public void refreshDeviceGroups(List<Group> groups) {
		groupRepository.save(groups);
		groupRepository.flush();
	}

}
