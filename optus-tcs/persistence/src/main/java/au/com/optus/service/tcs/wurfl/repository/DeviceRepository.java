package au.com.optus.service.tcs.wurfl.repository;

import org.springframework.data.repository.CrudRepository;

import au.com.optus.service.tcs.wurfl.jpa.domain.Device;

public interface DeviceRepository extends CrudRepository<Device, Long> {

	Device findByUserAgent(String userAgent);

}
