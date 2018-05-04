package com.revature.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.revature.beans.Bean;

public class BeanDOMParser {
	/*
	 * Read the entire XML document into memory as a tree
	 * Pros:
	 * 	Allows for quick access of any node
	 * 	Modification of the document in tree form: Then write tree to document
	 * Cons:
	 * 	Huge memory commitment (not good for large documents)
	 */
	public static void main(String[] args) {
		/*List<Bean> bList = new ArrayList<Bean>();
		bList.add(new Bean("Richard","Pinto",1,2000,false));
		bList.add(new Bean("Frederico","Legume",120,20,true));
		bList.add(new Bean("Alice","Garbonzo",5,85,true));
		
		writeBeans("beans.xml", bList);*/
		System.out.println(readBeans("beans.xml"));
	}
	private static List<Bean> readBeans(String filename) {
		List <Bean> list = new ArrayList<Bean>();
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filename);
			
			//We've read the entire document into memory
			//We have to normalize the document to make it usable.
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());
			
			// Get all of the Bean elements
			NodeList beanList = doc.getDocumentElement().getElementsByTagName("bean");
			for(int i=0; i<beanList.getLength(); i++) {
				Bean b = new Bean();
				list.add(b);
				Node bean = beanList.item(i);
				NamedNodeMap attributes = bean.getAttributes();
				b.setName(attributes.getNamedItem("name").getTextContent());
				
				NodeList beanChildren = bean.getChildNodes();
				for(int j=0; j<beanChildren.getLength(); j++) {
					Node child = beanChildren.item(j);
					if(child.getNodeType()==Node.ELEMENT_NODE) {
						switch(child.getNodeName()) {
						case "strain":
							b.setStrain(child.getTextContent());
							break;
						case "yield":
							b.setYield(Integer.parseInt(child.getTextContent()));
							break;
						case "mass":
							b.setMass(Double.parseDouble(child.getTextContent()));
							break;
						case "tasty":
							b.setTasty(Boolean.parseBoolean(child.getTextContent()));
							break;
						default: //oh no!
							break;
						}
					}
				}
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unused")
	private static void writeBeans(String filename, List<Bean> list) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			
			Element root = doc.createElement("beans"); //<beans> </beans>
			doc.appendChild(root);
			for(Bean b : list) {
				// Bean itself
				Element bean = doc.createElement("bean"); //<bean> <bean>
				root.appendChild(bean);
				
				// Name
				bean.setAttribute("name", b.getName()); // <bean name="name"></bean>
				
				// Strain
				Element strain = doc.createElement("strain");
				bean.appendChild(strain);
				strain.appendChild(doc.createTextNode(b.getStrain()));
				
				// Yield
				Element yield = doc.createElement("yield");
				bean.appendChild(yield);
				yield.appendChild(doc.createTextNode(""+b.getYield()));
				
				// Mass
				Element mass = doc.createElement("mass");
				bean.appendChild(mass);
				mass.appendChild(doc.createTextNode(""+b.getMass()));
				
				// tastiness
				Element tasty = doc.createElement("tasty");
				bean.appendChild(tasty);
				tasty.appendChild(doc.createTextNode(""+b.isTasty()));
			}
			TransformerFactory cybertron = TransformerFactory.newInstance();
			Transformer jetfire = cybertron.newTransformer();
			jetfire.setOutputProperty(OutputKeys.INDENT, "yes");
			jetfire.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			
			jetfire.transform(source, result); //and rollout
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// OREOBOT! NOOOOOOOOOOOOOOOOOOOOOOOO!
			e.printStackTrace();
		} catch (TransformerException e) {
			// OREOBOT! NOOOOOOOOOOOOOOOOOOOOOOOO!
			e.printStackTrace();
		}
	}
}