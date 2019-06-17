package by.training.xmlparsing.main;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.training.xmlparsing.handler.SimpleSaxParser;

public class Runner {
	public static void main(String[] args) {
		try {
			// �������� SAX-�����������
			XMLReader reader = XMLReaderFactory.createXMLReader();
			SimpleSaxParser handler = new SimpleSaxParser();
			reader.setContentHandler(handler);
			reader.parse("data/devices.xml");
		} catch (SAXException e) {
			System.err.print("������ SAX ������� " + e);
		} catch (IOException e) {
			System.err.print("������ I/� ������ " + e);
		}
	}
}
