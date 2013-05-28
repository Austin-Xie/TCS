package au.com.optus.service.tcs.wurfl.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import au.com.optus.service.tcs.wurfl.jpa.domain.Device;


public interface DeviceRepository extends JpaRepository<Device, Long> {//CrudRepository<Device, Long> {

	Device findByUserAgent(String userAgent);

}
