package by.training.xmlparsing.builder;

import java.io.IOException;
import java.util.Set;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.handler.DeviceSaxHandler;

public class DeviceSaxBuilder implements DeviceBuilder {
	private Set<Device> devices;
	private DeviceSaxHandler deviceSaxHandler;
	private XMLReader reader;

	public DeviceSaxBuilder() {
		// �������� SAX-�����������
		deviceSaxHandler = new DeviceSaxHandler();
		try {
			// �������� �������-�����������
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(deviceSaxHandler);
		} catch (SAXException e) {
			System.err.print("������ SAX �������: " + e);
		}
	}

	@Override
	public Set<Device> getDevices() {
		return devices;
	}

	@Override
	public void buildSetDevices(String fileName) {
		try {
			// ������ XML-���������
			reader.parse(fileName);
		} catch (SAXException e) {
			System.err.print("������ SAX �������: " + e);
		} catch (IOException e) {
			System.err.print("������ I/� ������: " + e);
		}
		devices = deviceSaxHandler.getDevices();
	}
}
