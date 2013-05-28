package au.com.optus.service.tcs.wurfl.repository;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import au.com.optus.service.tcs.wurfl.jpa.domain.Device;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:repository-context.xml")
@Transactional
public class DeviceRepositoryTest {

	@Autowired
	DeviceRepository repository;

	@Before
	public void setUp() {

	}

	@Test
	public void test() {
		Iterable<Device> findAll = repository.findAll();
		Iterator<Device> it = findAll.iterator();
		while(it.hasNext()) {
			System.out.println("device loaded");
		}

		Long id = 0L;
		try {
			Device device2 = new Device();
			System.out.println("id = " + device2.getId());
			device2.setUserAgent("xieweiy");
			Device device = repository.save(device2);
			repository.flush();
			System.out.println(device.getUserAgent());
			id = device.getId();
		} catch (Exception e) {
			System.out.println(e);
		}

		Device findOne = repository.findOne(id);
		System.out.println("findOne id = " + findOne.getUserAgent());


	}
}
