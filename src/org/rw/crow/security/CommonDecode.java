package org.rw.crow.security;

import java.io.IOException;

import sun.misc.BASE64Decoder;

/**
 * Common data decode.
 * @author Crow
 * @date 2015年8月4日
 */
public class CommonDecode {

	
	public static String Base64(String msg){
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] byteData = null;
		String clearText = "";
		try {
			byteData = decoder.decodeBuffer(msg);
			clearText = new String(byteData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clearText;
	}
}
