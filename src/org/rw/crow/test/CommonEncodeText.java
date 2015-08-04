package org.rw.crow.test;

import org.rw.crow.security.CommonEncode;

public class CommonEncodeText {
	public static void main(String[] args) {
		base64Encode("123456");
	}
	
	private static void base64Encode(String msg){
		System.out.println(CommonEncode.Base64(msg));
	}
}
