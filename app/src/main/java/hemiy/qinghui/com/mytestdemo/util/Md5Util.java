package hemiy.qinghui.com.mytestdemo.util;

import java.security.MessageDigest;

/**
 * 加密工具类
 *
 */
public class Md5Util {
	
	/*
	 * 32位加密
	 */
	public static String md5(String plainText){ 
		StringBuffer buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(plainText.getBytes()); 	
			byte[] b = md.digest();
			int i; 
			buf = new StringBuffer(""); 
			
			for (int offset = 0; offset < b.length; offset++) { 
				i = b[offset]; 
				if(i < 0) 
					i += 256; 
				if(i < 16) 
					buf.append("0"); buf.append(Integer.toHexString(i)); 
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf.toString();
	}
	
	/*
	 * 16位加密
	 */
	public static String md5_16(String plainText){ 
		StringBuffer buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(plainText.getBytes()); 	
			byte[] b = md.digest();
			int i; 
			buf = new StringBuffer(""); 
			
			for (int offset = 0; offset < b.length; offset++) { 
				i = b[offset]; 
				if(i < 0) 
					i += 256; 
				if(i < 16) 
					buf.append("0"); buf.append(Integer.toHexString(i)); 
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf.toString().substring(8,24);
	}
	
}
