package com.revature.io;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class BeanSAXParser {
	/*
	 * Simple API for XML
	 * SAX parsing allows you to parse a document one event at a time
	 * Pros:
	 * 	FAST
	 * 	Low memory usage
	 * Cons:
	 * 	Cannot modify the file
	 * 	Slow if you only want a certain portion of the file.
	 * Secret:
	 * 	To create the DOM, we parse it using SAX
	 */
	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			BeanHandler handler = new BeanHandler();
			saxParser.parse("beans.xml", handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
