package by.training.xmlparsing.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
import by.training.xmlparsing.builder.DeviceParserEnum;
import by.training.xmlparsing.builder.ParserException;

public class DeviceSaxHandler extends DefaultHandler{
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	private Set<Device> devices;
	private Device current = null; 
	private DeviceParserEnum currentEnum = null;
	
	
	public DeviceSaxHandler() {
		devices = new HashSet<>();
	}
	
	public Set<Device> getDevices() {
		return devices;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		DeviceParserEnum classEnum = DeviceParserEnum.valueOf(localName.toUpperCase());
		if (EnumSet.range(DeviceParserEnum.MOUSE, DeviceParserEnum.CPU).contains(classEnum)) {
			switch (classEnum) {
			case MOUSE:
				current = new Mouse();
				break;
			case DISPLAY:
				current = new Display();
				break;
			case SSD:
				current = new SSD();
				break;
			case HDD:
				current = new HDD();
				break;
			case MOTHERBOARD:
				current = new MotherBoard();
				break;
			case CPU:
				current = new CPU();
				break;
			default:
				return;
			}
			String attrName = attributes.getLocalName(0);
			String name = null;
			String strDate = null;
			if (attrName.equals("name")) {
				name = attributes.getValue(0);
				strDate = attributes.getValue(1);
			} else {
				strDate = attributes.getValue(0);
				name = attributes.getValue(1);
			}
			current.setName(name);
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM", Locale.ENGLISH).parse(strDate);
			} catch (ParseException e) {
				LOGGER.error(e.getMessage(), e);
			}
			current.setDateOfIssue(date);
		} else if (EnumSet.range(DeviceParserEnum.ORIGIN, DeviceParserEnum.FREQUENCY).contains(classEnum)){
			currentEnum = classEnum;
		}

	}
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch, start, length).trim();
	
		if (currentEnum != null) {
			switch (currentEnum) {
			case ORIGIN:
				current.setOrigin(s);
				break;
			case PRICE:
				current.setPrice(Double.parseDouble(s));
				break;
			case ISCRITICAL:
				current.setCritical(Boolean.parseBoolean(s));
				break;
			case WATT:
				List<Type> types = current.getTypes();
				types.add(new EnergyConsumption(Double.parseDouble(s)));
				break;
			case ISPERIPHERAL:
				types = current.getTypes();
				types.add(new Peripheral(Boolean.parseBoolean(s)));
				break;
			case ISCOOLER:
				types = current.getTypes();
				types.add(new Cooller(Boolean.parseBoolean(s)));
				break;
			case ISWIRELESS:
				((Mouse) current).setWireless(Boolean.parseBoolean(s));
				break;
			case RESOLUTIONX:
				((Display) current).setResolutionX(Integer.parseInt(s));
				break;
			case RESOLUTIONY:
				((Display) current).setResolutionY(Integer.parseInt(s));
				break;
			case RPM:
				((HDD) current).setRpm(Integer.parseInt(s));
				break;
			case SPEED:
				((SSD) current).setSpeed(Integer.parseInt(s));
				break;
			case CAPACITY:
				((Store) current).setCapacity(Integer.parseInt(s));
				break;
			case FREQUENCY:
				((CPU) current).setFrequency(Integer.parseInt(s));
				break;
			case PORT:
				List<Port> ports = ((MotherBoard) current).getPorts();
				ports.add(Port.valueOf(s));
				break;
			default:
				break;
			}
		} 
		currentEnum = null;
	}


	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		DeviceParserEnum classEnum = DeviceParserEnum.valueOf(localName.toUpperCase());
		if (EnumSet.range(DeviceParserEnum.MOUSE, DeviceParserEnum.MOTHERBOARD).contains(classEnum)) {
			devices.add(current);
		}
	}
	
	

}
