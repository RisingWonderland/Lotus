package org.rw.crow.security;

import sun.misc.BASE64Encoder;

/**
 * Common data encode.
 * @author Crow
 * @date 2015年8月4日
 */
public class CommonEncode {

	/**
	 * Base64 encode.
	 * @author Crow
	 * @date 2015年8月4日
	 * @param msg
	 * @return
	 */
	public static String Base64(String msg){
		BASE64Encoder encoder = new BASE64Encoder();
		String cipherText = encoder.encode(msg.getBytes());
		return cipherText;
	}
}
