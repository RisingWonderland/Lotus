package org.rw.crow.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Data encode by HASH.
 * @author Crow
 * @date 2015年8月2日
 *
 */
public class Encode {
	
	public static final String MD5 = "MD5";
	public static final String SHA = "SHA";
	public static final String SHA256 = "SHA-256";
	public static final String SHA512 = "SHA-512";
	
	/**
	 * The method of hash encode.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param eType the hash algorithm type
	 * @param msg the content to be encoded
	 * @return
	 */
	private static String hashEncode(String hashType, String msg){
		MessageDigest md;
		String cipherText = null;
		try {
			md = MessageDigest.getInstance(hashType);
			byte[] data = md.digest(msg.getBytes());
			cipherText = bytesToHexString(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return cipherText;
	}
	
	/**
	 * byte[] to hex string.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexString(byte[] bytes) {   
		StringBuffer sb = new StringBuffer(bytes.length);
		String sTemp;
		for (int i = 0; i < bytes.length; i++) {
			sTemp = Integer.toHexString(0xFF & bytes[i]);
			if (sTemp.length() < 2){
				sb.append(0);
			}
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}
	
	
	/**
	 * MD5.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param msg
	 * @return
	 */
	public static String MD5(String msg){
		return hashEncode(MD5, msg);
	}
	
	/**
	 * SHA.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param msg
	 * @return
	 */
	public static String SHA(String msg){
		return hashEncode(SHA, msg);
	}
	
	/**
	 * SHA-256.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param msg
	 * @return
	 */
	public static String SHA_256(String msg){
		return hashEncode(SHA256, msg);
	}
	
	/**
	 * SHA-512.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param msg
	 * @return
	 */
	public static String SHA_512(String msg){
		return hashEncode(SHA512, msg);
	}
}
