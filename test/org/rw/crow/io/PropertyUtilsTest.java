package org.rw.crow.io;

import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rw.crow.commons.PropertyUtils;

public class PropertyUtilsTest {

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
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetPropertyStream() {
		String propertyPath = "/info.properties";
		InputStream is = PropertyUtils.getPropertyStream(propertyPath);
	}
	
	@Test
	public void testGetProperty() {
		String propertyPath = "/info.properties";
		String name = PropertyUtils.getProperty(propertyPath, "name");
		String github = PropertyUtils.getProperty(propertyPath, "github");
		System.out.println(name + " / " + github);
	}
	
	@Test
	public void testGetAllProperty() {
		String propertyPath = "/info.properties";
		HashMap<String, String> map = PropertyUtils.getAllProperty(propertyPath);
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
