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
				System.out.println("text.xml创建成功！");
				FileOutputStream os = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				osw.write(DocumentHelper.parseText(text).asXML());
				osw.flush();
				osw.close();
				os.close();
				System.out.println("xml数据写入成功！");
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
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//获取文档创建工厂对象
			DocumentBuilder builder = factory.newDocumentBuilder();//获取文档创建对象
			Element element = builder.parse(file).getDocumentElement();//获取文档元素
			NodeList list = element.getElementsByTagName("name");//获取指定文档内容
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
