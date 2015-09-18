package org.rw.crow.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rw.crow.array.ArrayUtils;

/**
 * 
 * @author Crow
 * @date 2015年9月2日
 *
 */
public class ArrayUtilsTest {
	
	@Test
	public static void common() {
		int[] arr1 = {1, 5, 12, 7, 43, 3};
		System.out.println("Source array: " + Arrays.toString(arr1));
		
		int[] extreme = ArrayUtils.getExtreme(arr1);
		System.out.println("Extreme valus: " + Arrays.toString(extreme));
		
		ArrayUtils.reverse(arr1);
		System.out.println("Reversed array: " + Arrays.toString(arr1));
		
		System.out.println("SUM array: " + ArrayUtils.sum(arr1));
		
		System.out.println("AVG array: " + ArrayUtils.avg(arr1));
		
		ArrayUtils.pow(arr1, 2);
		System.out.println("POW array: " + Arrays.toString(arr1));
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
	public void testGetMinIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExtremeIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMinDoubleArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxDoubleArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExtremeDoubleArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMinFloatArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxFloatArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExtremeFloatArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMinLongArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxLongArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExtremeLongArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMinShortArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxShortArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExtremeShortArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMinCharArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxCharArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExtremeCharArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMinByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExtremeByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapObjectArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapIntArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapDoubleArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapFloatArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapLongArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapShortArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapCharArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapByteArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverseObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverseIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverseDoubleArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverseFloatArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverseLongArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverseShortArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverseCharArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverseByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumDoubleArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumFloatArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumLongArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumShortArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testAvgIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testAvgDoubleArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testAvgFloatArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testAvgLongArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testAvgShortArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testAvgByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testPowIntArrayDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testPowDoubleArrayDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testPowFloatArrayDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testPowLongArrayDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testPowShortArrayDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testPowByteArrayDouble() {
		fail("Not yet implemented");
	}

}
