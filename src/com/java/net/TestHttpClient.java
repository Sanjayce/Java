package com.java.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestHttpClient {

	public static void main(String[] args) {
		new HttpClientGet().start();
		new HttpClientPost().start();
	}
	
	static class HttpClientGet extends Thread{
		
		HttpClient hc = HttpClients.createDefault();//��ȡHttpClient����
		
		@Override
		public void run() {
			HttpGet hg = new HttpGet("http://fanyi.youdao.com/openapi.do?keyfrom=JKXY-test&key=343166845&type=data&doctype=xml&version=1.1&q=welcome");//��ȡHttpGetʾ��
			try {
				HttpResponse response = hc.execute(hg);//��ȡ��������
				HttpEntity he = response.getEntity();//��ȡ������Դ
				String data = EntityUtils.toString(he, "UTF-8");
				
				File mFile = new File("http.xml");
				FileWriter fw = new FileWriter(mFile);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(data);
				bw.flush();
				
				FileReader fr = new FileReader(mFile);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while((line = br.readLine())!=null){
					System.out.println(line);
				}
				fw.close();
				bw.close();
				br.close();
				fr.close();
			    
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class HttpClientPost extends Thread{
		
		HttpClient hc = HttpClients.createDefault();//��ȡHttpClient����
		
		@Override
		public void run() {
			HttpPost hp = new HttpPost("http://fanyi.youdao.com/openapi.do");//��ȡHttpPostʾ��
			try {
				
				List<BasicNameValuePair>mlist = new ArrayList<>();//��ȡһ��ͨ�ü�ֵ�Լ���
				mlist.add(new BasicNameValuePair("keyfrom", "JKXY-test"));
				mlist.add(new BasicNameValuePair("key", "343166845"));
				mlist.add(new BasicNameValuePair("type", "data"));
				mlist.add(new BasicNameValuePair("doctype", "xml"));
				mlist.add(new BasicNameValuePair("version", "1.1"));
				mlist.add(new BasicNameValuePair("q", "welcome"));
				
				hp.setEntity(new UrlEncodedFormEntity(mlist));//���÷��ʵ�ַ
				
				HttpResponse response = hc.execute(hp);//��ȡ��������
				HttpEntity he = response.getEntity();//��ȡ������Դ
				String data = EntityUtils.toString(he, "UTF-8");
				System.out.println(data);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
