package au.com.optus.service.tcs.wurfl.jpa.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.optus.service.tcs.wurfl.jpa.domain.Device;

@Service
public class DeviceDao extends GenericDao<Device>{

	@Override
	@Transactional
	public void createEntity(Device e) {
		super.createEntity(e);
	}
}
