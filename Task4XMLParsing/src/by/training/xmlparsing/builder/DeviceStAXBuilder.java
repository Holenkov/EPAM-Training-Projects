package by.training.xmlparsing.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import by.training.xmlparsing.bean.type.Cooler;
import by.training.xmlparsing.bean.type.EnergyConsumption;
import by.training.xmlparsing.bean.type.Peripheral;
import by.training.xmlparsing.bean.type.Type;

public class DeviceStAXBuilder implements DeviceBuilder{
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	private Set<Device> devices = new HashSet<>();
	private XMLInputFactory inputFactory;
	private Device current;

	public DeviceStAXBuilder(String xsdPath) {
		
		try {
			String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
			Schema schema = xsdFactory.newSchema(new File(xsdPath));
			
			
			inputFactory = XMLInputFactory.newInstance();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}

	public Set<Device> getDevices() {
		return devices;
	}

	public void buildSetDevices(InputStream input) throws ParserException {
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;
		try {
		//	inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(input);
			// StAX parsing
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					DeviceParserEnum classEnum = DeviceParserEnum.valueOf(name.toUpperCase());
					if (EnumSet.range(DeviceParserEnum.MOUSE, DeviceParserEnum.CPU).contains(classEnum)) {
						buildDevice(reader);
						devices.add(current);
					}  else if (EnumSet.range(DeviceParserEnum.ORIGIN, DeviceParserEnum.FREQUENCY).contains(classEnum)){
						buildFields(reader);
					}
				}
			}
		} catch (XMLStreamException e) {
			throw new ParserException("StAX parsing error! ", e);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				throw new ParserException("Impossible close file ", e);
			}
		}
	}
	
	private void buildDevice(XMLStreamReader reader) throws ParserException {
		String className = reader.getLocalName();
		DeviceParserEnum classEnum = DeviceParserEnum.valueOf(className.toUpperCase());
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
			break;
		}
		int count = reader.getAttributeCount();
		for (int i = 0; i < count; i++) {
			String attrName = reader.getAttributeLocalName(i);
			DeviceParserEnum attrEnum = DeviceParserEnum.valueOf(attrName.toUpperCase());
			switch (attrEnum) {
			case NAME:
				String name = reader.getAttributeValue(null, DeviceParserEnum.NAME.getValue());
				current.setName(name);
				break;
			case DATE:
				String strDate = reader.getAttributeValue(null, DeviceParserEnum.DATE.getValue());
				Date date = null;
				try {
					date = new SimpleDateFormat("yyyy-MM", Locale.ENGLISH).parse(strDate);
				} catch (ParseException e) {
					LOGGER.error(e.getMessage(), e);
				}
				current.setDateOfIssue(date);
				break;
			default:
				break;
			}
		}
	}
	
	private void buildFields(XMLStreamReader reader) throws ParserException {
		try {
					String name = reader.getLocalName();
					DeviceParserEnum classEnum = DeviceParserEnum.valueOf(name.toUpperCase());
					if (EnumSet.range(DeviceParserEnum.ORIGIN, DeviceParserEnum.FREQUENCY).contains(classEnum)){
						switch (classEnum) {
						case ORIGIN:
							current.setOrigin(getXMLText(reader));
							break;
						case PRICE:
							current.setPrice(Double.parseDouble(getXMLText(reader)));
							break;
						case ISCRITICAL:
							current.setCritical(Boolean.parseBoolean(getXMLText(reader)));
							break;
						case WATT:
							List<Type> types = current.getTypes();
							types.add(new EnergyConsumption(Double.parseDouble(getXMLText(reader))));
							break;
						case ISPERIPHERAL:
							types = current.getTypes();
							types.add(new Peripheral(Boolean.parseBoolean(getXMLText(reader))));
							break;
						case ISCOOLER:
							types = current.getTypes();
							types.add(new Cooler(Boolean.parseBoolean(getXMLText(reader))));
							break;
						case ISWIRELESS:
							((Mouse) current).setWireless(Boolean.parseBoolean(getXMLText(reader)));
							break;
						case RESOLUTIONX:
							((Display) current).setResolutionX(Integer.parseInt(getXMLText(reader)));
							break;
						case RESOLUTIONY:
							((Display) current).setResolutionY(Integer.parseInt(getXMLText(reader)));
							break;
						case RPM:
							((HDD) current).setRpm(Integer.parseInt(getXMLText(reader)));
							break;
						case SPEED:
							((SSD) current).setSpeed(Integer.parseInt(getXMLText(reader)));
							break;
						case CAPACITY:
							((Store) current).setCapacity(Integer.parseInt(getXMLText(reader)));
							break;
						case FREQUENCY:
							((CPU) current).setFrequency(Integer.parseInt(getXMLText(reader)));
							break;
						case PORT:
							List<Port> ports = ((MotherBoard) current).getPorts();
							ports.add(Port.valueOf(getXMLText(reader)));
							break;
						default:
							return;
				}
			}
		} catch (XMLStreamException e) {
			throw new ParserException("StAX parsing error! ", e);
		}
	}
	
	private String getXMLText(XMLStreamReader reader) throws XMLStreamException, ParserException { 
		String text = null; 
		if (reader.hasNext()) { 
			reader.next(); 
			try {
				text = reader.getText();
			} catch (IllegalStateException e) {
				throw new ParserException("Impossible close file ", e);
			}
			
			} 
		return text; 
		}

	
}
