package org.rw.crow.test;

import org.rw.crow.security.Encode;

/**
 * Test hash encode.
 * @author Crow
 * @date 2015年8月2日
 *
 */
public class HashEncodeTest {
	public static void main(String[] args) {
		String msg = "123456";
		String md5 = Encode.MD5(msg);
		String sha = Encode.SHA(msg);
		String sha_256 = Encode.SHA_256(msg);
		String sha_512 = Encode.SHA_512(msg);
		System.out.println(md5);
		System.out.println(sha);
		System.out.println(sha_256);
		System.out.println(sha_512);
	}
}
