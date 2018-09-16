package com.java.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
//***.jar
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestHTTP {

	public static void main(String[] args) {
		new HttpGet().start();
		new HttpPost().start();

	}

	// HTTP->Get
	static class HttpGet extends Thread {
		@Override
		public void run() {
			try {
				URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=JKXY-test&key=343166845&type=data&doctype=xml&version=1.1&q=welcome");
				HttpURLConnection uc = (HttpURLConnection)url.openConnection();
				InputStream is = uc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String line;
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				isr.close();
				is.close();
				System.out.println(sb.toString());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	// HTTP->Post
	static class HttpPost extends Thread {

		@Override
		public void run() {
			try {
				URL url = new URL("http://fanyi.youdao.com/openapi.do");
				HttpURLConnection huc = (HttpURLConnection) url.openConnection();
				huc.addRequestProperty("encoding", "UTF-8");// 设置默认编码格式
				huc.setDoInput(true);
				huc.setDoOutput(true);
				huc.setUseCaches(false);
				huc.setRequestMethod("POST");// 设置网络读取方式
				// 设置访问地址
				OutputStream os = huc.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write("keyfrom=JKXY-test&key=343166845&type=data&doctype=xml&version=1.1&q=welcome");
				bw.flush();
				//解析数据
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String line;
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				bw.close();
				osw.close();
				os.close();
				br.close();
				isr.close();
				is.close();
				System.out.println(sb.toString());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
