package org.rw.crow.example;

import org.rw.crow.array.ArrayUtils;

/**
 * 测试Array工具类
 * @author Crow
 * @date 2015年5月1日 上午9:57:43
 * @version v0.1
 */
public class ArrayTest {
	public static void main(String[] args) {
		int[] arr1 = {1, 5, 12, 7, 43};
		ArrayUtils.sortAsc(arr1);
		for(int num : arr1){
			System.out.println(num);
		}
		
		int[] extreme = ArrayUtils.getExtreme(arr1);
		System.out.println(extreme[0]);
		System.out.println(extreme[1]);
	}
}
