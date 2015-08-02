package org.rw.crow.test;

import java.util.Arrays;

import org.rw.crow.array.ArrayUtils;

/**
 * Test ArrayUtils
 * @author Crow
 * @date 2015年5月1日
 */
public class ArrayUtilsTest {
	public static void main(String[] args) {
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
}
