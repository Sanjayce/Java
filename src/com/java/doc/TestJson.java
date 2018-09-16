package com.java.doc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//json-lib.jar
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//gson.jar
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestJson {

	private static File file;

	public static void main(String[] args) {

		file = new File("file.json");
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("file.json�ļ������ɹ�!");
				CreateJsonByJSON();
				System.out.println("json���ݴ����ɹ�!");
				ReadJson();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				FileInputStream is = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				if (br.readLine() != null) {
					ReadJson();
				} else {
					System.out.println("json����Ϊ�գ����������!");
				}
				br.close();
				isr.close();
				is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ͨ��JSONԭ����ʽ����json����
	public static void CreateJsonByJSON() {
		JSONObject mObject = new JSONObject();

		JSONObject mObject1 = new JSONObject();
		mObject1.put("name", "��С��");
		mObject1.put("sec", "��");
		mObject1.put("age", 20);
		mObject1.put("birthday", "1991/1/1");
		mObject1.put("has_girlfrind", false);

		JSONArray mArray = new JSONArray();
		mArray.add("CF");
		mArray.add("LOL");

		mObject1.put("hobbliy", mArray);
		mObject.put("json", mObject1);

		try {
			FileOutputStream os = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write(mObject.toString());
			osw.flush();
			osw.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ͨ��gson(json)��ʽ����json����
	 */
	public static void ReadJson() {

		try {
			JsonParser mParser = new JsonParser();
			JsonObject mObject = (JsonObject) mParser.parse(new FileReader(file));
			JsonObject childObject = mObject.getAsJsonObject("json");
			String name = childObject.get("name").getAsString();
			String sex = childObject.get("sec").getAsString();
			int age = childObject.get("age").getAsInt();
			String birthday = childObject.get("birthday").getAsString();
			boolean girlfrind = childObject.get("has_girlfrind").getAsBoolean();
			JsonArray mArray = childObject.getAsJsonArray("hobbliy");
			String hobbliy1 = mArray.get(0).getAsString();
			String hobbliy2 = mArray.get(1).getAsString();
			System.out.println("������" + name + "\n" + "�Ա�" + sex + "\n" + "���䣺"
					+ age + "\n" + "�������£�" + birthday + "\n" + "�Ƿ��飺"
					+ girlfrind + "\n" + "���ã�" + hobbliy1 + "," + hobbliy2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͨ��gson(GSON)��ʽ
	 * fromJson() / toJson()
	 */
	
	public static void ReadByGSON(){
		
	    //new Gson().fromJson();
		//new Gson().toJson();
	
	}
}
