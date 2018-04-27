package com.revature.io;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BeanHandler extends DefaultHandler {

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// When SAX sees a string, we should do something
		String str = new String(ch, start, length);
		str=str.trim();
		if(!str.equals("")) {
			System.out.println(str);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Document ends");
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		System.out.println();
	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
		System.out.println("IGNORE ME");
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document Begins");
	}

	@Override
	public void startElement(String uri, String localname, String qName, Attributes attr) throws SAXException {
		System.out.println(qName+": ");
		for(int i = 0; i< attr.getLength(); i++) {
			System.out.println("\t"+attr.getValue(i));
		}
	}

}
