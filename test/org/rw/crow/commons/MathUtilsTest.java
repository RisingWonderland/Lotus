package org.rw.crow.commons;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MathUtilsTest {

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
	public void testPrecisionDecimal() {
		double num = 232.4338903427124;
		double result = MathUtils.precisionDecimal(num, 2);
		System.out.println(result);
	}
	
	@Test
	public void testPrecisionDecimalFormatForFraction() {
		double num = 232.4338903427124;
		String result = MathUtils.precisionDecimalFormatForFraction(num, 1);
		System.out.println(result);
		
	}

}
