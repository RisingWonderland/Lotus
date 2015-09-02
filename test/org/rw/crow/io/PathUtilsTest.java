package org.rw.crow.io;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PathUtilsTest {

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
	public void getStringTest() {
		String path = PathUtils.getFilePath("README.md", 
			"C:\\\"Workspaces\"\\MyEclipse Professional 2014\\Lotus", 
			"alice/kepler/", 
			"galileo");
		System.out.println(path);
	}

}
