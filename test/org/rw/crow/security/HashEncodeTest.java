package org.rw.crow.security;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rw.crow.security.HashEncode;

public class HashEncodeTest {
	
	@Test
	public void commonTest() {
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMD5String() {
		fail("Not yet implemented");
	}

	@Test
	public void testMD5File() {
		fail("Not yet implemented");
	}

	@Test
	public void testSHA() {
		fail("Not yet implemented");
	}

	@Test
	public void testSHA_256() {
		fail("Not yet implemented");
	}

	@Test
	public void testSHA_512() {
		fail("Not yet implemented");
	}

}
