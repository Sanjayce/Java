package com.java.doc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestDom4j {
	private static File file;

	public static void main(String[] args) {
		Dom4j();
	}
	
	public static void Dom4j(){
		String text = "<root> <name> <firstname> Sanjay </firstname> <lastname> Xu </lastname> </name> </root>";
		try {
			file = new File("text.xml");
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("text.xml�����ɹ���");
				FileOutputStream os = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				osw.write(DocumentHelper.parseText(text).asXML());
				osw.flush();
				osw.close();
				os.close();
				System.out.println("xml����д��ɹ���");
				ReadXml();
				return;
			}
			ReadXml();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ReadXml(){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//��ȡ�ĵ�������������
			DocumentBuilder builder = factory.newDocumentBuilder();//��ȡ�ĵ���������
			Element element = builder.parse(file).getDocumentElement();//��ȡ�ĵ�Ԫ��
			NodeList list = element.getElementsByTagName("name");//��ȡָ���ĵ�����
			for (int i = 0; i < list.getLength(); i++) {
				Element lan = (Element) list.item(i);
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
