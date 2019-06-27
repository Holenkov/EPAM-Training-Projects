package by.training.xmlparsing.builder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.training.xmlparsing.bean.CPU;
import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.bean.Display;
import by.training.xmlparsing.bean.HDD;
import by.training.xmlparsing.bean.MotherBoard;
import by.training.xmlparsing.bean.Mouse;
import by.training.xmlparsing.bean.Port;
import by.training.xmlparsing.bean.SSD;
import by.training.xmlparsing.bean.Store;
import by.training.xmlparsing.bean.type.Cooller;
import by.training.xmlparsing.bean.type.EnergyConsumption;
import by.training.xmlparsing.bean.type.Peripheral;
import by.training.xmlparsing.bean.type.Type;

public class DeviceDOMBuilder implements DeviceBuilder{
	private Set<Device> devices= new HashSet<Device>();
	private DocumentBuilder docBuilder;

	public DeviceDOMBuilder() throws ParserException {
		// �������� DOM-�����������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new ParserException("DOM parser configuration error", e);
		}
	}
	
	@Override
	public Set<Device> getDevices() {
		return devices;
	}

	@Override
	public void buildSetDevices(InputStream input) throws ParserException {
		Document doc = null;
		try {
			doc = docBuilder.parse(input);
			Element root = doc.getDocumentElement();

			NodeList deviceList = root.getElementsByTagName("*");
			for (int i = 0; i < deviceList.getLength(); i++) {
				Element element = (Element) deviceList.item(i);
				String name = deviceList.item(i).getNodeName();
				DeviceParserEnum classEnum = DeviceParserEnum.valueOf(name.toUpperCase());
				if (EnumSet.range(DeviceParserEnum.MOUSE, DeviceParserEnum.CPU).contains(classEnum)) {
					Device device = buildDevice(element);
					devices.add(device);
				}
			}
		} catch (IOException e) {
			throw new ParserException("SAX parser problems", e);
		} catch (SAXException e) {
			throw new ParserException("I/O error", e);
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
				current = buildCPU(element);
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
	
	private List<Type> buildTypes(Element element) {
		List<Type> types = new ArrayList<>();
		NodeList typesList = element.getElementsByTagName("*");
		for (int i = 0; i < typesList.getLength(); i++) {
			Element typeElement = (Element) typesList.item(i);
			String name = typesList.item(i).getNodeName();
			DeviceParserEnum classEnum = DeviceParserEnum.valueOf(name.toUpperCase());
			switch (classEnum) {
			case ENERGY:
				String text = getElementTextContent(typeElement, "watt");
				types.add(new EnergyConsumption(Double.parseDouble(text)));
				break;
			case PERIPHERAL:
				text = getElementTextContent(typeElement, "isPeripheral");
				types.add(new Peripheral(Boolean.parseBoolean(text)));
				break;
			case COOLER:
				text = getElementTextContent(typeElement, "isCooler");
				types.add(new Cooller(Boolean.parseBoolean(text)));
				break;
			default:
				break;
			}
		}
		return types;
	}
	
	private Mouse buildMouse(Element element) {
		Mouse mouse = new Mouse();
		mouse.setWireless(Boolean.parseBoolean(getElementTextContent(element, "isWireless")));
		return mouse;
	}
	
	private CPU buildCPU(Element element) {
		CPU cpu = new CPU();
		cpu.setFrequency(Integer.parseInt(getElementTextContent(element, "frequency")));
		return cpu;
	}
	
	private Display buildDisplay(Element element) {
		Display display = new Display();
		display.setResolutionX(Integer.parseInt(getElementTextContent(element, "resolutionX")));
		display.setResolutionY(Integer.parseInt(getElementTextContent(element, "resolutionY")));
		return display;
	}
	
	private MotherBoard buildMotherBoard(Element element) {
		MotherBoard motherBoard = new MotherBoard();
		Element elemPorts = (Element) element.getElementsByTagName("ports").item(0);
		NodeList portsList = elemPorts.getElementsByTagName("*");
		for (int i = 0; i < portsList.getLength(); i++) {
			Element portElement = (Element) portsList.item(i);
			String text = portElement.getTextContent();
			List<Port> ports = motherBoard.getPorts();
			ports.add(Port.valueOf(text));
		}
		return motherBoard;
	}
	
	private Store buildStore(Element element) {
		Store current = new Store();
		String className = element.getNodeName();
		DeviceParserEnum classEnum = DeviceParserEnum.valueOf(className.toUpperCase());
			switch (classEnum) {
			case HDD:
				current = buildHDD(element);
				break;
			case SSD:
				current = buildSSD(element);
				break;
			default:
				break;
			}
		current.setCapacity(Integer.parseInt(getElementTextContent(element, "capacity")));
		return current;
	}
	
	private HDD buildHDD(Element element) {
		HDD hdd = new HDD();
		hdd.setRpm(Integer.parseInt(getElementTextContent(element, "rpm")));
		return hdd;
	}
	
	private SSD buildSSD(Element element) {
		SSD ssd = new SSD();
		ssd.setSpeed(Integer.parseInt(getElementTextContent(element, "speed")));
		return ssd;
	}
	
	
	
	
	private static String getElementTextContent(Element element, String elementName) {     
		try {
			NodeList nList = element.getElementsByTagName(elementName);     
		} catch (NullPointerException e) {
			return null; 
		}
		NodeList nList = element.getElementsByTagName(elementName);     
		Node node = nList.item(0);     
		String text = node.getTextContent();     
		return text; 
		}

	
	

}
