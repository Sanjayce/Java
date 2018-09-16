package com.java.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class Urls {

	/**
	 * URL��
	 */
	public static void main(String[] args) {
		
		Hosts();
		System.out.println("***************************");
		Net();
	}
	
	/**
	 * ͨ��URL�����������ַ
	 */
	public static void Net(){
		try {
			URL url = new URL("http://www.baidu.com");
			URLConnection mConnection = url.openConnection();
			InputStream is = mConnection.getURL().openStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader bis = new BufferedReader(isr);
			String line=null;
			while((line=bis.readLine())!=null){
				System.out.println(line);
			}
			bis.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * URL���÷���
	 */
	public static void Hosts(){
		
		try {
			URL url = new URL("http://www.baidu.com");
			URL url2 = new URL(url, "/title.html?userName==tom#text");
			System.out.println("Э�飺"+url2.getProtocol());
			System.out.println("���ݣ�"+url2.getContent());
			System.out.println("·����"+url2.getPath());
			System.out.println("�˿ڣ�"+url2.getPort());
			System.out.println("�ļ�����"+url2.getFile());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
