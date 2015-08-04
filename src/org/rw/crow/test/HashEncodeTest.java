package org.rw.crow.test;

import java.io.File;

import org.rw.crow.security.HashEncode;

/**
 * Test hash encode.
 * @author Crow
 * @date 2015年8月2日
 *
 */
public class HashEncodeTest {
	public static void main(String[] args) {
		// 计算文件MD5
		File file = new File("/home/yang/Desktop/a.sh");
		System.out.println(HashEncode.MD5(file));
		
		
		String msg = "123456";
		String md5 = HashEncode.MD5(msg);
		String sha = HashEncode.SHA(msg);
		String sha_256 = HashEncode.SHA_256(msg);
		String sha_512 = HashEncode.SHA_512(msg);
		System.out.println(md5);
		System.out.println(sha);
		System.out.println(sha_256);
		System.out.println(sha_512);
	}
}
