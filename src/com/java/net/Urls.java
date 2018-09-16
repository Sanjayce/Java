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
	 * URL类
	 */
	public static void main(String[] args) {
		
		Hosts();
		System.out.println("***************************");
		Net();
	}
	
	/**
	 * 通过URL来访问网络地址
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
	 * URL常用方法
	 */
	public static void Hosts(){
		
		try {
			URL url = new URL("http://www.baidu.com");
			URL url2 = new URL(url, "/title.html?userName==tom#text");
			System.out.println("协议："+url2.getProtocol());
			System.out.println("内容："+url2.getContent());
			System.out.println("路径："+url2.getPath());
			System.out.println("端口："+url2.getPort());
			System.out.println("文件名："+url2.getFile());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
