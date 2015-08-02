package org.rw.crow.commons;

/**
 * Provides some methods for String.
 * @author Crow
 * @date 2015年8月2日
 *
 */
public class StringUtils {
	
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
}
