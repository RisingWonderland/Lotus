package org.rw.crow.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.rw.crow.commons.StringUtils;

/**
 * Data encode.
 * @author Crow
 * @date 2015年8月2日
 *
 */
public class HashEncode {
	
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
			cipherText = StringUtils.bytes2HexString(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return cipherText;
	}
	
	
	/**
	 * MD5 encode.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param msg
	 * @return
	 */
	public static String MD5(String msg){
		return hashEncode(MD5, msg);
	}
	
	/**
	 * Get a file's MD5.
	 * @author Crow
	 * @date 2015年8月4日
	 * @param file
	 * @return
	 */
	public static String MD5(File file){
		String result = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			MappedByteBuffer mbb = fis.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md = MessageDigest.getInstance("MD5");

			// support big file
			byte[] buffer = new byte[8192];
			int length;
			while((length = fis.read(buffer)) != -1){
				md.update(buffer, 0, length);
			}
			
			BigInteger bi = new BigInteger(1, md.digest());
			result = bi.toString(16).toUpperCase();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	/**
	 * SHA encode.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param msg
	 * @return
	 */
	public static String SHA(String msg){
		return hashEncode(SHA, msg);
	}
	
	/**
	 * SHA-256 encode.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param msg
	 * @return
	 */
	public static String SHA_256(String msg){
		return hashEncode(SHA256, msg);
	}
	
	/**
	 * SHA-512 encode.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param msg
	 * @return
	 */
	public static String SHA_512(String msg){
		return hashEncode(SHA512, msg);
	}
	
	
}
