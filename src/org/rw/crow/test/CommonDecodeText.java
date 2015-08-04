package org.rw.crow.test;

import org.rw.crow.security.CommonDecode;

public class CommonDecodeText {
	public static void main(String[] args) {
		Base64Decode("MTIzNDU2");
	}
	
	
	public static void Base64Decode(String msg){
		System.out.println(CommonDecode.Base64(msg));
	}
}
