package by.training.xmlparsing.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.training.xmlparsing.bean.CPU;
import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.bean.Display;
import by.training.xmlparsing.bean.HDD;
import by.training.xmlparsing.bean.MotherBoard;
import by.training.xmlparsing.bean.Mouse;
import by.training.xmlparsing.bean.SSD;

public class DeviceStAXBuilder {
	private Set<Device> devices = new HashSet<>();
	private XMLInputFactory inputFactory;

	public DeviceStAXBuilder() {
		inputFactory = XMLInputFactory.newInstance();
		}

	public Set<Device> getStudents() {
		return devices;
	}

	public void buildSetStudents(String fileName) {
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			// StAX parsing
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					DeviceParserEnum classEnum = DeviceParserEnum.valueOf(name.toUpperCase());
					if (EnumSet.range(DeviceParserEnum.MOUSE, DeviceParserEnum.CPU).contains(classEnum)) {
						Device device = buildDevice(reader);
						devices.add(device);
					}
				}
			}
		} catch (XMLStreamException ex) {
			System.err.println("StAX parsing error! " + ex.getMessage());
		} catch (FileNotFoundException ex) {
			System.err.println("File " + fileName + " not found! " + ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				System.err.println("Impossible close file " + fileName + " : " + e);
			}
		}
	}
	
	private Device buildDevice(Element element) throws ParserException {
		String className = element.getNodeName();
		DeviceParserEnum classEnum = DeviceParserEnum.valueOf(className.toUpperCase());
		Device current = null;
			switch (classEnum) {
			case MOUSE:
				current = buildMouse(element);
				break;
			case DISPLAY:
				current = buildDisplay(element);
				break;
			case HDD:
				current = buildStore(element);
				break;
			case SSD:
				current = buildStore(element);
				break;
			case MOTHERBOARD:
				current = buildMotherBoard(element);
				break;
			case CPU:
				current = new CPU();
				break;
			default:
				break;
			}
			String name = element.getAttribute("name");
			String strDate = element.getAttribute("date");
			current.setName(name);
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM", Locale.ENGLISH).parse(strDate);
			} catch (ParseException e) {
				throw new ParserException("Date parse problems", e);
			}
			current.setDateOfIssue(date);
			current.setOrigin(getElementTextContent(element, "origin"));
			current.setPrice(Double.parseDouble(getElementTextContent(element, "price")));
			NodeList typesList = element.getElementsByTagName("types");
			Element types = (Element) typesList.item(0);
			current.setTypes(buildTypes(types));
			current.setCritical(Boolean.parseBoolean(getElementTextContent(element, "isCritical")));
		return current;
	}
	
	
	
}
