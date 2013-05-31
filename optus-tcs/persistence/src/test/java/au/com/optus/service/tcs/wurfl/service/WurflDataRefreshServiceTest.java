package au.com.optus.service.tcs.wurfl.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.ZipInputStream;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:repository-context.xml")
//@Transactional
public class WurflDataRefreshServiceTest {

	@Autowired
	WurflDataRefreshService refreshServcie;

	@Test
	//	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void testRefreshWurflData() throws FileNotFoundException, IOException, JSONException {

		try {
			refreshServcie.refreshWurflData(new FileReader(new File("/home/austin/Projects/TCS/wurfl_dev.xml")), "wurfl.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//	@Test
	public void testXmlToJson() throws FileNotFoundException, IOException, JSONException {
		JSONObject xmlToJson = refreshServcie.xmlToJson(new ZipInputStream(new FileInputStream(new File("/home/austin/Projects/TCS/wurfl.xml.zip"))), "wurfl.xml");
		System.out.println("sourceName === " + xmlToJson.get("sourceName"));
	}
}
