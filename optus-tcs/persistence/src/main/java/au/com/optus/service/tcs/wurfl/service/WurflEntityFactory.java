package au.com.optus.service.tcs.wurfl.service;

import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import au.com.optus.service.tcs.wurfl.jpa.domain.Device;
import au.com.optus.service.tcs.wurfl.jpa.domain.Group;
import au.com.optus.service.tcs.wurfl.jpa.domain.WurflSource;

@Service
public class WurflEntityFactory {

	Device createDevice(JSONObject jsonDevice, WurflSource wurflSource) throws JSONException {
		Device device = new Device();
		if (jsonDevice.has("actual_device_root")) {
			device.setActualDeviceRoot(jsonDevice.getString("actual_device_root"));
		} else {
			device.setActualDeviceRoot("");
		}
		device.setFallBack(jsonDevice.getString("fall_back"));
		device.setDeviceId(jsonDevice.getString("id"));
		device.setUserAgent(jsonDevice.getString("user_agent"));
		device.setWurflSource(wurflSource);

		device.setLastUpdatedTime(Calendar.getInstance());
		device.setLastUpdater("Austin");
		device.setIsPatched(false);

		device.setDigest("");

		/*if (jsonDevice.has("group")) {
			JSONArray jsonGrps = jsonDevice.optJSONArray("group");
			if (null != jsonGrps) {
				for (int i = 0; i < jsonGrps.length(); i++) {
					Group grp = createGroup(jsonGrps.getJSONObject(i), device);
					device.addGroup(grp);
				}
			} else {
				JSONObject jsonGrp = jsonDevice.getJSONObject("group");
				device.addGroup(createGroup(jsonGrp, device));
			}
		}*/

		return device;
	}

	Group createGroup(JSONObject jsonGroup, Device device) throws JSONException {

		Group group = new Group();
		group.setDevice(device);
		group.setGroupId(jsonGroup.getString("id"));
		System.out.println("group id = " + jsonGroup.getString("id"));

		group.setDigest("to be generated");
		group.setLastUpdatedTime(Calendar.getInstance());
		group.setJsonCapabilities(jsonGroup.toString());

		/*
		if (jsonGroup.has("capability")) {
			JSONArray capaArray = jsonGroup.optJSONArray("capability");
			if (null != capaArray) {
				group.setJsonCapabilities(capaArray.toString());
				for (int i = 0; i < capaArray.length(); i++) {
					Capability capa1 = createCapability(capaArray.getJSONObject(i), group);
					group.addCapability(capa1);
				}
			} else {
				JSONObject jsonCapa = jsonGroup.getJSONObject("capability");
				group.setJsonCapabilities(jsonCapa.toString());
				Capability capa2 = createCapability(jsonCapa, group);
				group.addCapability(capa2);
			}

		} else {
			group.setJsonCapabilities("");
		}
		 */

		return group;
	}

	WurflSource createWurflSource(JSONObject jsonWurfl) {
		WurflSource ws = new WurflSource();
		ws.setMemo("Test Wrulf Refreshing");
		ws.setSourceName(jsonWurfl.optString("sourceName"));
		ws.setSourceType("wurfl_xml");
		ws.setUpdater("Austin");
		ws.setSourceData("xml".getBytes());

		return ws;
	}

}
