package org.rw.crow.example;

import java.util.Arrays;

import org.rw.crow.array.ArrayUtils;

/**
 * Test ArrayUtils
 * @author Crow
 * @date 2015年5月1日
 * @version v0.1
 */
public class ArrayTest {
	public static void main(String[] args) {
		int[] arr1 = {1, 5, 12, 7, 43};
		System.out.println("Source array: " + Arrays.toString(arr1));
		
		int[] extreme = ArrayUtils.getExtreme(arr1);
		System.out.println("Extreme valus: " + Arrays.toString(extreme));
		
		ArrayUtils.reverse(arr1);
		System.out.println("Reversed array: " + Arrays.toString(arr1));
		
		Arrays.sort(arr1);
		System.out.println(3 / 2);
	}
}
