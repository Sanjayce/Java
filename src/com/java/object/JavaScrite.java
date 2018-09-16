package com.java.object;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class JavaScrite {
	
	private static String DATA;
	private static String datas;

	/**
	 * java开发知识四：加密，异常
	 * @param args
	 */
	public static void main(String[] args)throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("*****欢迎使用X密码工具*****");
		while (true) {
			System.out.println("加密方式: 1.MD5  2.SHA 3.HMAC 4.BASE64 5.DES 6.3DES(异常) 7.AES 0.Exit");
			int num = sc.nextInt();
			if (num == 1) {
				System.out.println("请输入文本文档:");
				DATA = sc.next();
				
				datas = MessageDigestUtil.getMD5ForByte(DATA);
				System.out.println(DATA + ">>MD5加密>>" + datas);
				System.out.println("--------------------");
			} else if (num == 2) {
				System.out.println("请输入文本文档:");
				DATA = sc.next();
				
				datas = MessageDigestUtil.getSHAForByte(DATA);
				System.out.println(DATA + ">>SHA加密>>" + datas);
				System.out.println("--------------------");
			}  else if (num == 3) {
				System.out.println("请输入文本文档:");
				DATA = sc.next();
				
				byte[] miyao = MessageDigestUtil.ToKeyHmac();
				System.out.println(BytesToHex.fromBytesToHex(miyao));
				
				datas = MessageDigestUtil.getHMACForByte(DATA);
				System.out.println(DATA + ">>Hmac加密>>" + datas);
				System.out.println("--------------------");
			} else if(num == 4){
				System.out.println("请输入文本文档:");
				DATA = sc.next();
				
				String show = Base64Util.Base64Bianma(DATA);
				System.out.println(DATA + ">>Base64加密>>" + show);
				
				String back = Base64Util.Base64Jiema(show);
				System.out.println(show + ">>Base64解密>>" + back);
			}else if(num == 5){
				System.out.println("请输入文本文档:");
				DATA = sc.next();
				
				byte[] miyao = DuiChenScrateUtil.getKey();
				System.out.println(BytesToHex.fromBytesToHex(miyao));
				
				byte[] data1 = DuiChenScrateUtil.encretyScrite(DATA.getBytes(), miyao);
				datas = BytesToHex.fromBytesToHex(data1);
				System.out.println(DATA+">>DES加密>>"+datas);
				
				byte[] data2 = DuiChenScrateUtil.decrtyScrite(data1, miyao);
				System.out.println(datas+">>DES解密>>"+new String(data2));
			}else if(num == 6){
				System.out.println("请输入文本文档:");
				DATA = sc.next();
				
				byte[] miyao = DuiChenScrateUtil.initKey();
				System.out.println(BytesToHex.fromBytesToHex(miyao));
				
				byte[] data1 = DuiChenScrateUtil.DESdecrtySecrt(DATA.getBytes(), miyao);
				datas = BytesToHex.fromBytesToHex(data1);
				System.out.println(DATA+">>3DES加密>>"+datas);
				
				byte[] data2 = DuiChenScrateUtil.DESdecrtySecrt(data1, miyao);
				System.out.println(datas+">>3DES解密>>"+new String(data2));
				
			}else if(num == 7){
				System.out.println("请输入文本文档:");
				DATA = sc.next();
				
				byte[] miyao = DuiChenScrateUtil.getInitKey();
				System.out.println(BytesToHex.fromBytesToHex(miyao));
				
				byte[] data1 = DuiChenScrateUtil.AESencytSecrt(DATA.getBytes(), miyao);
				datas = BytesToHex.fromBytesToHex(data1);
				System.out.println(DATA+">>AES加密>>"+datas);
				byte[] data2 = DuiChenScrateUtil.AESdncytSecrt(data1, miyao);
				System.out.println(datas+">>AES解密>>"+new String(data2));
			}else if (num == 0) {
				System.out.println("*****谢谢使用X密码工具*****");
				System.exit(0);
				break;
			}else {
				System.out.println("请输入合法字符!!!");
				System.out.println("--------------------");
			}
		}
	}

}

/**
 * Base64
 */
class Base64Util {

	/**
	 * 加密
	 */
	
	public static String Base64Bianma(String str) {
		byte[] date = str.getBytes();
		return new BASE64Encoder().encode(date);
	}

	/**
	 * 解密
	 */

	public static String Base64Jiema(String date) throws Exception {
		byte[] relute = new BASE64Decoder().decodeBuffer(date);
		return new String(relute);
	}
}

/**
 * 字节数组转换为十六进制数
 */
class BytesToHex {

	public static String fromBytesToHex(byte[] dates){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < dates.length; i++) {
			if(Integer.toHexString(0xFF & dates[i]).length() == 1){
				builder.append("0").append(Integer.toHexString(0xFF & dates[i]));
			}else{
				builder.append(Integer.toHexString(0xFF & dates[i]));
			}
		}
		return builder.toString();
	}
}

/**
 * 对称加密
 *
 */

class DuiChenScrateUtil {

	/**
	 * DES
	 */
	//获取公钥
	public static byte[] getKey() throws Exception {

		KeyGenerator mKeyGenerator = KeyGenerator.getInstance("DES");
		//mKeyGenerator.init(56);
		SecretKey mSecretKey = mKeyGenerator.generateKey();
		return mSecretKey.getEncoded();
	}

	//加密
	public static byte[] encretyScrite(byte[] date, byte[] key)throws Exception {
		SecretKey mSecretKey = new SecretKeySpec(key, "DES");
		Cipher ci = Cipher.getInstance("DES");
		ci.init(Cipher.ENCRYPT_MODE, mSecretKey);
		byte[] jiami = ci.doFinal(date);
		return jiami;
	}

	//解密
	public static byte[] decrtyScrite(byte[] date, byte[] key) throws Exception {
		SecretKey mSecretKey = new SecretKeySpec(key, "DES");
		Cipher ci = Cipher.getInstance("DES");
		ci.init(Cipher.DECRYPT_MODE, mSecretKey);
		byte[] jiemi = ci.doFinal(date);
		return jiemi;
	}

	/**
	 * 3DES
	 */
	public static byte[] initKey() throws NoSuchAlgorithmException{
		KeyGenerator mGenerator = KeyGenerator.getInstance("DESede");
		 mGenerator.init(168);//112/168
		SecretKey mkey = mGenerator.generateKey();
		return mkey.getEncoded();
	}

	public static byte[] DESencrtySecrt(byte[] date, byte[] key)
			throws Exception {
		SecretKey mSecretKey = new SecretKeySpec(key, "DESede");
		Cipher ci1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		ci1.init(Cipher.ENCRYPT_MODE, mSecretKey);
		byte[] jiami1 = ci1.doFinal(date);
		return jiami1;
	}

	public static byte[] DESdecrtySecrt(byte[] date, byte[] key)
			throws Exception {
		SecretKey mSecretKey = new SecretKeySpec(key, "DESede");
		Cipher ci1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		ci1.init(Cipher.DECRYPT_MODE, mSecretKey);
		byte[] jiemi1 = ci1.doFinal(date);
		return jiemi1;
	}
	
	/**
	 * AES
	 */

	public static byte[] getInitKey() throws NoSuchAlgorithmException{
		KeyGenerator mGenerator = KeyGenerator.getInstance("AES");
		//mGenerator.init(128);
		SecretKey mkey = mGenerator.generateKey();
		return mkey.getEncoded();
	}
	
	public static byte[] AESencytSecrt(byte[] data,byte[] key){
		SecretKey mSecretKey = new SecretKeySpec(key, "AES");
		try {
			Cipher ci3 = Cipher.getInstance("AES");
			ci3.init(Cipher.ENCRYPT_MODE, mSecretKey);
			byte [] jiami = ci3.doFinal(data);
			return jiami;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] AESdncytSecrt(byte[] data,byte[] key){
		SecretKey mSecretKey = new SecretKeySpec(key, "AES");
		try {
			Cipher ci3 = Cipher.getInstance("AES");
			ci3.init(Cipher.DECRYPT_MODE, mSecretKey);
			byte [] jiami = ci3.doFinal(data);
			return jiami;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

}

/**
 * 非对称加密
 */
class FeiDuiChenScrateUtil {

	private static final String PUBLIC_KEY = "publickey";
	private static final String PRIVATE_KEY = "privatekey";
	
	public static Map<String,Object> initKey() throws Exception{
		
		KeyPairGenerator mKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
		mKeyPairGenerator.initialize(1024);
		KeyPair mKeyPair = mKeyPairGenerator.generateKeyPair();
		
		RSAPublicKey pubkey = (RSAPublicKey) mKeyPair.getPublic();
		RSAPrivateKey prikey = (RSAPrivateKey) mKeyPair.getPrivate();
		Map<String,Object>map = new HashMap<String,Object>();
		map.put(PUBLIC_KEY, pubkey);
		map.put(PRIVATE_KEY, prikey);
		return map;
	}
}

/**
 * 消息摘要
 */
class MessageDigestUtil {
	// MD5
	public static String getMD5ForByte(String str) throws Exception {
		
		byte[] date = str.getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(date);
		byte[] resulte = md.digest();
		String hex = BytesToHex.fromBytesToHex(resulte);
		return hex;
	}

	// SHA
	public static String getSHAForByte(String str) throws Exception {
		
		byte[] date = str.getBytes();
		MessageDigest sha = MessageDigest.getInstance("SHA");
		sha.update(date);
		byte[] resulte = sha.digest();
		String hex = BytesToHex.fromBytesToHex(resulte);
		return hex;
	}

	// HMACMD5
	public static String getHMACForByte(String str) throws Exception {
		byte[] key = ToKeyHmac();
		SecretKey mKey = new SecretKeySpec(key, "HmacMD5");
		Mac mac = Mac.getInstance("HmacMD5");
		mac.init(mKey);
		byte[] resultKey = mac.doFinal();
		String hex = BytesToHex.fromBytesToHex(resultKey);
		return hex;

	}

	//key
	public static byte[] ToKeyHmac() throws Exception{
		
		KeyGenerator mKeyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey mSecretKey = mKeyGenerator.generateKey();
		return  mSecretKey.getEncoded();
	}

}