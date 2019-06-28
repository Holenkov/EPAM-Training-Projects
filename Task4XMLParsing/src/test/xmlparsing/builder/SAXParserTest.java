package test.xmlparsing.builder;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.bean.Display;
import by.training.xmlparsing.bean.type.EnergyConsumption;
import by.training.xmlparsing.bean.type.Peripheral;
import by.training.xmlparsing.builder.DeviceBuilder;
import by.training.xmlparsing.builder.DeviceBuilderFactory;
import by.training.xmlparsing.builder.ParserException;

@RunWith(Parameterized.class)
public class SAXParserTest {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private String sourceXMLPath;
	private Device expected;
	private static DeviceBuilder deviceBuilder;

	public SAXParserTest(String sourceXMLPath, Device expected) {
		super();
		this.sourceXMLPath = sourceXMLPath;
		this.expected = expected;
	}

	@Parameters
	public static List<Object[]> paramsForTest() {
		List<Object[]> forTest = new ArrayList<>();
		String dirPath = ".\\data\\test\\";
		
		//device 1
		String sourcePath = dirPath + "device1.xml";
		Device device = new Display();
		device.setName("1 Samsung S710");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM", Locale.ENGLISH).parse("2019-01");
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
		}
		device.setDateOfIssue(date);
		device.setPrice(151.50);
		device.setOrigin("Taiwan");
		device.setTypes(new ArrayList<>(Arrays.asList(new EnergyConsumption(40.0), new Peripheral(true))));
		device.setCritical(true);
		((Display) device).setResolutionX(1024);
		((Display) device).setResolutionY(768);
		forTest.add(new Object[] { sourcePath, device });
		
		//device 2
		sourcePath = dirPath + "device2.xml";
		device = new Display();
		device.setName("1 Samsung S710");
		try {
			date = new SimpleDateFormat("yyyy-MM", Locale.ENGLISH).parse("2019-01");
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
		}
		device.setDateOfIssue(date);
		device.setPrice(151.50);
		device.setOrigin("Taiwan");
		device.setTypes(new ArrayList<>(Arrays.asList(new EnergyConsumption(40.0), new Peripheral(true))));
		device.setCritical(true);
		((Display) device).setResolutionX(1024);
		((Display) device).setResolutionY(768);
		forTest.add(new Object[] { sourcePath, device });
		
		//device 3
		sourcePath = dirPath + "device3.xml";
		device = new Display();
		device.setName("1 Samsung S710");
		try {
			date = new SimpleDateFormat("yyyy-MM", Locale.ENGLISH).parse("2019-01");
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
		}
		device.setDateOfIssue(date);
		device.setPrice(151.50);
		device.setOrigin("No information");
		device.setTypes(new ArrayList<>(Arrays.asList(new EnergyConsumption(40.0), new Peripheral(true))));
		device.setCritical(true);
		((Display) device).setResolutionX(1024);
		((Display) device).setResolutionY(768);
		forTest.add(new Object[] { sourcePath, device });
		
		return forTest;
	}
	
	
	/*<display name = "1 Samsung S710" date = "2019-01">
		<origin></origin>
		<price>151.50</price>
		<types>
			<energy>
				<watt>40.0</watt>
			</energy>
			<peripheral>
				<isPeripheral>true</isPeripheral>
			</peripheral>
		</types>
		<isCritical>true</isCritical>
		<resolutionX>1024</resolutionX>
		<resolutionY>768</resolutionY>
	</display>*/

	@BeforeClass
	public static void createBuilder() {
	
		
	}
	
	@Test
	public void parse() {
		final String DEVICES_XSD = ".\\data\\test\\device.xsd";
		Set<Device> actual = null;
		try {
			deviceBuilder = DeviceBuilderFactory.createDeviceBuilder("SAX", DEVICES_XSD);
			File file = new File(sourceXMLPath);
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(file);
				deviceBuilder.buildSetDevices(inputStream);
				actual = deviceBuilder.getDevices();
			} catch (FileNotFoundException e) {
				LOGGER.error(e.getMessage(), e);
			} 			
		} catch (ParserException e1) {
			LOGGER.error(e1.getMessage(), e1);
		} 
		Set<Device> expectedSet = new HashSet<>();
		expectedSet.add(expected);
		assertEquals(expectedSet, actual);

	}

}
