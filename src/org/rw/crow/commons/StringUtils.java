package org.rw.crow.commons;

import java.nio.charset.Charset;

import org.rw.crow.regular.CheckValid;

/**
 * Provides some methods for String.
 * @author Crow
 * @date 2015年8月2日
 *
 */
public class StringUtils {
	
	// charset
	public static final Charset CHARSET_GBK = Charset.forName("GBK");
	public static final Charset CHARSET_ISO_8859_1 = Charset.forName("ISO-8859-1");
	public static final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");
	
	
	private StringUtils(){}
	
	/**
	 * Convert hex string to byte array.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param hexString
	 * @return
	 */
	public static byte[] hexString2Bytes(String hexString){
		int len = (hexString.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hexString.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (char2Byte(achar[pos]) << 4 | char2Byte(achar[pos + 1]));
		}
		return result;
	}
	
	/**
	 * Convert byte array to hex string.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param bytes
	 * @return
	 */
	public static String bytes2HexString(byte[] bytes){
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
	 * Convert char to byte.
	 * @author Crow
	 * @date 2015年8月2日
	 * @param c
	 * @return
	 */
	private static byte char2Byte(char c){
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	
	
	
	/**
	 * Charset convert.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param str
	 * @param from
	 * @param to
	 * @return
	 */
	public static String charsetConvert(String str, Charset from, Charset to) {
		if(CheckValid.checkIsNull(str) || CheckValid.checkIsNull(from) || CheckValid.checkIsNull(to)) {
			throw new IllegalArgumentException("Wrong, parameter value can not be null.");
		}
		
		if(str.equals("")) {
			return "";
		}
		
		return new String(str.getBytes(from), to);
	}
	
	
	/**
	 * Convert Chinese characters to Unicode-16.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param str
	 * @return
	 */
	public static String convertChinese2Unicode16(String str) {
		if(CheckValid.checkIsNull(str)) {
			throw new IllegalArgumentException("Wrong, parameter value can not be null.");
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0,l = str.length(); i < l; i++) {
			int u = str.charAt(i);
			String hex = Integer.toHexString(u);
			sb.append("\\u" + hex);
		}
		return sb.toString();
	}
	
	/**
	 * Convert Unicode-16 to Chinese.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param str
	 * @return
	 */
	public static String convertUnicode16ToChinese(String str) {
		StringBuilder sb = new StringBuilder();
		
		int beginIndex = -1, endIndex = 0;
		while((beginIndex = str.indexOf("\\u", endIndex)) != -1) {
			// 检测、截取并保留非转换字符串
			sb.append(str.substring(endIndex, beginIndex));
			
			// 转换内容
			if(beginIndex + 5 < str.length()) {
				endIndex = beginIndex + 6;
				sb.append((char) Integer.parseInt(str.substring(beginIndex + 2, endIndex), 16));
			}
		}
		sb.append(str.substring(endIndex));
		
		return sb.toString();
	}
}
