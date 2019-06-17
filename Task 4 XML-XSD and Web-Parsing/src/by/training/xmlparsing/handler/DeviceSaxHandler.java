package by.training.xmlparsing.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.training.xmlparsing.bean.Device;
import by.training.xmlparsing.bean.Mouse;

public class DeviceSaxHandler extends DefaultHandler{
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
		if ("mouse".equals(localName)) {
			current = new Mouse();
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
				e.printStackTrace();
			}
			current.setDateOfIssue(date);

		}

	}
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch, start, length).trim();
		if (currentEnum != null) {
			
		}
	}

	String s = new String(ch, start, length).trim();  
	if (currentEnum != null) {        switch (currentEnum) {   case NAME:    current.setName(s);    break;   case TELEPHONE:    current.setTelephone(Integer.parseInt(s));    break;   case STREET:    current.getAddress().setStreet(s);    break;   case CITY:    current.getAddress().setCity(s);    break;   case COUNTRY:    current.getAddress().setCountry(s);    break;   default:

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	
	
	

}
