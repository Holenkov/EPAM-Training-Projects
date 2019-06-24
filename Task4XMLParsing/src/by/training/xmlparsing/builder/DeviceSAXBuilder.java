package by.training.xmlparsing.builder;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import by.training.xmlparsing.bean.Device;

public class DeviceSAXBuilder implements DeviceBuilder {
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	/** Set of Devices. */
	private Set<Device> devices;
	/** Handler. */
	private DeviceSaxHandler deviceSaxHandler;
	/** Reader. */
	private XMLReader reader;
	/** File path to XSD Schema. */
	//public static final String DEVICES_XSD = ".\\data\\devices.xsd";
	public static final String DEVICES_XSD = "d:/Epam Training Projects/Task4XMLParsing/data/devices.xsd";

	/**
	 * public DeviceSaxBuilder() throws ParserException
	 * Constructor. Initializes Handler and Reader using XSD Schema. 
	 * @throws ParserException - if some problems with Parser.
	 */
	public DeviceSAXBuilder() throws ParserException {
		// создание SAX-анализатора
		deviceSaxHandler = new DeviceSaxHandler();
		try {
			// create schema
			String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
			Schema schema = xsdFactory.newSchema(new File(DEVICES_XSD));

			// create SAXParser
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setNamespaceAware(true);
			spf.setValidating(true);
			spf.setSchema(schema);

			// создание объекта-обработчика
			SAXParser saxParser = spf.newSAXParser();
			reader = saxParser.getXMLReader();
			reader.setContentHandler(deviceSaxHandler);
		} catch (SAXException | ParserConfigurationException e) {
			throw new ParserException("SAX parser problems", e);
		}
	}

	/**
	 * public Set<Device> getDevices()
	 * Returns Set of Devices, parsed from xml file.
	 */
	@Override
	public Set<Device> getDevices() {
		return devices;
	}

	/**
	 * Parse data from xml file to Set.
	 */
	@Override
	public void buildSetDevices(final String fileNameXML) throws ParserException {
		try {
			reader.parse(fileNameXML);
		} catch (SAXException e) {
			throw new ParserException("SAX parser problems", e);
		} catch (IOException e) {
			throw new ParserException("I/O error", e);
		}
		devices = deviceSaxHandler.getDevices();
	}
}
