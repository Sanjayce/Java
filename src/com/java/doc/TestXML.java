package com.java.doc;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestXML {
	
	public static void main(String[] args) {
		File file = new File("Language.xml");
		if (!file.exists()) {
			CreateXml();			
		}
		ReadXml();
	}
	
	//DOM Create XML
	public static void CreateXml(){
		try {
			//��ȡDocumentBuilderFactoryʵ��
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//��ȡDocumentBuilderʵ��
			DocumentBuilder builder = factory.newDocumentBuilder();
			//��ȡDocumentʵ��
			Document document = builder.newDocument();
			//�������ڵ�
			Element element = document.createElement("Language");
			//Ϊ���ڵ�����Ԫ��
			element.setAttribute("cat", "it");
			//�����ӽڵ�
			Element lan1 = document.createElement("Lan");
			Element lan2 = document.createElement("Lan");
			Element lan3 = document.createElement("Lan");
			//Ϊ�ӽڵ㴴������
			lan1.setAttribute("id", "1");
			lan2.setAttribute("id", "2");
			lan3.setAttribute("id", "3");
			//Ϊ�ӽڵ���������ӽڵ�
			Element name1 = document.createElement("Name");
			Element name2 = document.createElement("Name");
			Element name3 = document.createElement("Name");
			Element ide1 = document.createElement("IDE");
			Element ide2 = document.createElement("IDE");
			Element ide3 = document.createElement("IDE");
			//Ϊ���ӽڵ㴴������
			name1.setTextContent("Java");
			name2.setTextContent("swift");
			name3.setTextContent("C#");
			ide1.setTextContent("Eclipse");
			ide2.setTextContent("Xcode");
			ide3.setTextContent("Visual Studio");
			//�ӽڵ���ӵ����ڵ�
			lan1.appendChild(name1);
			lan1.appendChild(ide1);
			lan2.appendChild(name2);
			lan2.appendChild(ide2);
			lan3.appendChild(name3);
			lan3.appendChild(ide3);
			element.appendChild(lan1);
			element.appendChild(lan2);
			element.appendChild(lan3);
			document.appendChild(element);
			//������������(ת�����ַ���)���
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter sw = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(sw));
			transformer.transform(new DOMSource(document), new StreamResult(new File("Language.xml")));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	//DOM Read XML
	public static void ReadXml(){
		try {
			//��ȡDocumentBuilderFactoryʵ��
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//��ȡDocumentBuilderʵ��
			DocumentBuilder builder = factory.newDocumentBuilder();
			//��ȡDocumentʵ��(��ȡ�Դ�����xml�ļ�)
			Document document = builder.parse(new File("Language.xml"));
			//��ȡDocumentʵ���е�Ԫ��
			Element element = document.getDocumentElement();
			System.out.println("cat:"+element.getAttribute("cat"));
			
			//��ȡ�ӽڵ�Ԫ��
			NodeList list = element.getElementsByTagName("Lan");
			for (int i = 0; i < list.getLength(); i++) {
				Element lan = (Element) list.item(i);
				System.out.println("****************");
				System.out.println("id="+lan.getAttribute("id"));
				
				NodeList clist = lan.getChildNodes();
				for (int j = 0; j < clist.getLength(); j++) {
					Node c = clist.item(j);
					if(c instanceof Element){
						System.out.println(c.getNodeName()+":"+c.getTextContent());
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
