package org.rw.crow.array;

/**
 * Array工具类
 * @author Crow
 * @date 2015年5月1日 上午9:59:54
 * @version v0.1
 */
public class ArrayUtils {
	
	
	private enum Enum {
		SORT_ASC, // 排列数组，升序
		SORT_DESC // 排列数组，降序
	}
	
	

	
	/*
	 * 获得数组中的极值
	 */
	/**
	 * 获得一个int型数组中的最小值
	 * @author Crow
	 * @date 2015年5月1日 上午10:04:27
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static int getMin(int[] arr){
		int length = arr.length;
		if(length > 0){
			int min = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[0] < min){
					min = arr[0];
				}
			}
			return min;
		}
		return 0;
	}
	
	/**
	 * 获得一个int型数组中的最大值
	 * @author Crow
	 * @date 2015年5月1日 上午10:02:35
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static int getMax(int[] arr){
		int length = arr.length;
		if(length > 0){
			int max = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[i] > max){
					max = arr[i];
				}
			}
			return max;
		}
		return 0;
	}
	
	/**
	 * 获得一个int数组中的最小值和最大值
	 * 返回一个拥有连个元素的int数组，元素1是最小值，元素2是最大值
	 * @author Crow
	 * @date 2015年5月1日 上午11:39:03
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static int[] getExtreme(int[] arr){
		int length = arr.length;
		if(length > 0){
			int max, min;
			max = min = arr[0];
			for(int i = 0;i < length;i++){
				int temp = arr[i];
				if(temp > max){
					max = temp;
				}
				if(temp < min){
					min = temp;
				}
			}
			return new int[]{min, max};
		}
		return new int[]{0, 0};
	}
	
	/**
	 * 获得一个double型数组中的最小值
	 * @author Crow
	 * @date 2015年5月1日 上午10:04:27
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static double getMin(double[] arr){
		int length = arr.length;
		if(length > 0){
			double min = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[0] < min){
					min = arr[0];
				}
			}
			return min;
		}
		return 0;
	}
	
	/**
	 * 获得一个double型数组中的最大值
	 * @author Crow
	 * @date 2015年5月1日 上午10:02:35
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static double getMax(double[] arr){
		int length = arr.length;
		if(length > 0){
			double max = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[i] > max){
					max = arr[i];
				}
			}
			return max;
		}
		return 0;
	}
	
	/**
	 * 获得一个double数组中的最小值和最大值
	 * 返回一个拥有连个元素的double数组，元素1是最小值，元素2是最大值
	 * @author Crow
	 * @date 2015年5月1日 上午11:39:03
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static double[] getExtreme(double[] arr){
		int length = arr.length;
		if(length > 0){
			double max, min;
			max = min = arr[0];
			for(int i = 0;i < length;i++){
				double temp = arr[i];
				if(temp > max){
					max = temp;
				}
				if(temp < min){
					min = temp;
				}
			}
			return new double[]{min, max};
		}
		return new double[]{0, 0};
	}
	
	/**
	 * 获得一个float型数组中的最小值
	 * @author Crow
	 * @date 2015年5月1日 上午10:04:27
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static float getMin(float[] arr){
		int length = arr.length;
		if(length > 0){
			float min = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[0] < min){
					min = arr[0];
				}
			}
			return min;
		}
		return 0;
	}
	
	/**
	 * 获得一个float型数组中的最大值
	 * @author Crow
	 * @date 2015年5月1日 上午10:02:35
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static float getMax(float[] arr){
		int length = arr.length;
		if(length > 0){
			float max = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[i] > max){
					max = arr[i];
				}
			}
			return max;
		}
		return 0;
	}
	
	/**
	 * 获得一个float数组中的最小值和最大值
	 * 返回一个拥有连个元素的float数组，元素1是最小值，元素2是最大值
	 * @author Crow
	 * @date 2015年5月1日 上午11:39:03
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static float[] getExtreme(float[] arr){
		int length = arr.length;
		if(length > 0){
			float max, min;
			max = min = arr[0];
			for(int i = 0;i < length;i++){
				float temp = arr[i];
				if(temp > max){
					max = temp;
				}
				if(temp < min){
					min = temp;
				}
			}
			return new float[]{min, max};
		}
		return new float[]{0, 0};
	}
	
	/**
	 * 获得一个long型数组中的最小值
	 * @author Crow
	 * @date 2015年5月1日 上午10:04:27
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static long getMin(long[] arr){
		int length = arr.length;
		if(length > 0){
			long min = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[0] < min){
					min = arr[0];
				}
			}
			return min;
		}
		return 0;
	}
	
	/**
	 * 获得一个long型数组中的最大值
	 * @author Crow
	 * @date 2015年5月1日 上午10:02:35
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static long getMax(long[] arr){
		int length = arr.length;
		if(length > 0){
			long max = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[i] > max){
					max = arr[i];
				}
			}
			return max;
		}
		return 0;
	}
	
	/**
	 * 获得一个long数组中的最小值和最大值
	 * 返回一个拥有连个元素的long数组，元素1是最小值，元素2是最大值
	 * @author Crow
	 * @date 2015年5月1日 上午11:39:03
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static long[] getExtreme(long[] arr){
		int length = arr.length;
		if(length > 0){
			long max, min;
			max = min = arr[0];
			for(int i = 0;i < length;i++){
				long temp = arr[i];
				if(temp > max){
					max = temp;
				}
				if(temp < min){
					min = temp;
				}
			}
			return new long[]{min, max};
		}
		return new long[]{0, 0};
	}
	
	/**
	 * 获得一个short型数组中的最小值
	 * @author Crow
	 * @date 2015年5月1日 上午10:04:27
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static short getMin(short[] arr){
		int length = arr.length;
		if(length > 0){
			short min = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[0] < min){
					min = arr[0];
				}
			}
			return min;
		}
		return 0;
	}
	
	/**
	 * 获得一个short型数组中的最大值
	 * @author Crow
	 * @date 2015年5月1日 上午10:02:35
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static short getMax(short[] arr){
		int length = arr.length;
		if(length > 0){
			short max = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[i] > max){
					max = arr[i];
				}
			}
			return max;
		}
		return 0;
	}
	
	/**
	 * 获得一个short数组中的最小值和最大值
	 * 返回一个拥有连个元素的short数组，元素1是最小值，元素2是最大值
	 * @author Crow
	 * @date 2015年5月1日 上午11:39:03
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static short[] getExtreme(short[] arr){
		int length = arr.length;
		if(length > 0){
			short max, min;
			max = min = arr[0];
			for(int i = 0;i < length;i++){
				short temp = arr[i];
				if(temp > max){
					max = temp;
				}
				if(temp < min){
					min = temp;
				}
			}
			return new short[]{min, max};
		}
		return new short[]{0, 0};
	}
	
	/**
	 * 获得一个char型数组中的最小值
	 * @author Crow
	 * @date 2015年5月1日 上午10:04:27
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static char getMin(char[] arr){
		int length = arr.length;
		if(length > 0){
			char min = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[0] < min){
					min = arr[0];
				}
			}
			return min;
		}
		return 0;
	}
	
	/**
	 * 获得一个char型数组中的最大值
	 * @author Crow
	 * @date 2015年5月1日 上午10:02:35
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static char getMax(char[] arr){
		int length = arr.length;
		if(length > 0){
			char max = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[i] > max){
					max = arr[i];
				}
			}
			return max;
		}
		return 0;
	}
	
	/**
	 * 获得一个char数组中的最小值和最大值
	 * 返回一个拥有连个元素的char数组，元素1是最小值，元素2是最大值
	 * @author Crow
	 * @date 2015年5月1日 上午11:39:03
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static char[] getExtreme(char[] arr){
		int length = arr.length;
		if(length > 0){
			char max, min;
			max = min = arr[0];
			for(int i = 0;i < length;i++){
				char temp = arr[i];
				if(temp > max){
					max = temp;
				}
				if(temp < min){
					min = temp;
				}
			}
			return new char[]{min, max};
		}
		return new char[]{0, 0};
	}
	
	/**
	 * 获得一个byte型数组中的最小值
	 * @author Crow
	 * @date 2015年5月1日 上午10:04:27
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static byte getMin(byte[] arr){
		int length = arr.length;
		if(length > 0){
			byte min = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[0] < min){
					min = arr[0];
				}
			}
			return min;
		}
		return 0;
	}
	
	/**
	 * 获得一个byte型数组中的最大值
	 * @author Crow
	 * @date 2015年5月1日 上午10:02:35
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static int getMax(byte[] arr){
		int length = arr.length;
		if(length > 0){
			byte max = arr[0];
			for(int i = 0;i < length;i++){
				if(arr[i] > max){
					max = arr[i];
				}
			}
			return max;
		}
		return 0;
	}
	
	/**
	 * 获得一个byte数组中的最小值和最大值
	 * 返回一个拥有连个元素的byte数组，元素1是最小值，元素2是最大值
	 * @author Crow
	 * @date 2015年5月1日 上午11:39:03
	 * @version v0.1
	 * @param arr
	 * @return
	 */
	public static byte[] getExtreme(byte[] arr){
		int length = arr.length;
		if(length > 0){
			byte max, min;
			max = min = arr[0];
			for(int i = 0;i < length;i++){
				byte temp = arr[i];
				if(temp > max){
					max = temp;
				}
				if(temp < min){
					min = temp;
				}
			}
			return new byte[]{min, max};
		}
		return new byte[]{0, 0};
	}
	
	
	
	/*
	 * 排序方法
	 */
	/**
	 * 升序排列Object数组
	 * @author Crow
	 * @date 2015年5月1日 上午10:27:43
	 * @version v0.1
	 * @param arr
	 */
	public static void sortAsc(Object[] arr){
		sort(arr, Enum.SORT_ASC);
	}
	
	/**
	 * 降序排列Object数组
	 * @author Crow
	 * @date 2015年5月1日 上午10:28:23
	 * @version v0.1
	 * @param arr
	 */
	public static void sortDesc(Object[] arr){
		sort(arr, Enum.SORT_DESC);
	}
	
	/**
	 * 排列Object数组，升序或降序，数组中元素需要实现Comparable接口
	 * @author Crow
	 * @date 2015年5月1日 上午10:09:30
	 * @version v0.1
	 * @param arr
	 * @param rule
	 */
	private static void sort(Object[] arr, Enum rule){
		for(int i=0;i < arr.length;i++){
			for(int j=0;j < arr.length-i-1;j++){
				Comparable<Object> com1 = (Comparable<Object>) arr[j];
				Comparable<Object> com2 = (Comparable<Object>) arr[j + 1];
				if(rule == Enum.SORT_ASC){
					// 因为是升序排列，所以，如果前者大于后者，交换双方位置
					if(com1.compareTo(com2) == 1){
						swap(arr, j, j + 1);
					}
				}else if(rule == Enum.SORT_DESC){
					// 因为是降序排列，所以，如果前者小于后者，交换双方位置
					if(com1.compareTo(com2) == -1){
						swap(arr, j, j + 1);
					}
				}
			}
		}
	}
	
	/**
	 * 升序排列int数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:03
	 * @version v0.1
	 * @param arr
	 */
	public static void sortAsc(int[] arr){
		sort(arr, Enum.SORT_ASC);
	}
	
	/**
	 * 降序排列int数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:38
	 * @version v0.1
	 * @param arr
	 */
	public static void sortDesc(int[] arr){
		sort(arr, Enum.SORT_DESC);
	}
	
	/**
	 * 排列int数组，升序或降序
	 * @author Crow
	 * @date 2015年5月1日 上午11:17:48
	 * @version v0.1
	 * @param arr
	 * @param rule
	 */
	private static void sort(int[] arr, Enum rule){
		for (int i = 0,il = arr.length;i < il;i++) {
			for (int j = 0,jl = il - i - 1; j < jl;j++) {
				if(rule == Enum.SORT_ASC){
					if (arr[j] > arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}else if(rule == Enum.SORT_DESC){
					if (arr[j] < arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}
			}
		}
	}
	
	/**
	 * 升序排列double数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:03
	 * @version v0.1
	 * @param arr
	 */
	public static void sortAsc(double[] arr){
		sort(arr, Enum.SORT_ASC);
	}
	
	/**
	 * 降序排列double数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:38
	 * @version v0.1
	 * @param arr
	 */
	public static void sortDesc(double[] arr){
		sort(arr, Enum.SORT_DESC);
	}
	
	/**
	 * 排列double数组，升序或降序
	 * @author Crow
	 * @date 2015年5月1日 上午11:17:48
	 * @version v0.1
	 * @param arr
	 * @param rule
	 */
	private static void sort(double[] arr, Enum rule){
		for (int i = 0,il = arr.length;i < il;i++) {
			for (int j = 0,jl = il - i - 1; j < jl;j++) {
				if(rule == Enum.SORT_ASC){
					if (arr[j] > arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}else if(rule == Enum.SORT_DESC){
					if (arr[j] < arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}
			}
		}
	}
	
	/**
	 * 升序排列float数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:03
	 * @version v0.1
	 * @param arr
	 */
	public static void sortAsc(float[] arr){
		sort(arr, Enum.SORT_ASC);
	}
	
	/**
	 * 降序排列float数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:38
	 * @version v0.1
	 * @param arr
	 */
	public static void sortDesc(float[] arr){
		sort(arr, Enum.SORT_DESC);
	}
	
	/**
	 * 排列float数组，升序或降序
	 * @author Crow
	 * @date 2015年5月1日 上午11:17:48
	 * @version v0.1
	 * @param arr
	 * @param rule
	 */
	private static void sort(float[] arr, Enum rule){
		for (int i = 0,il = arr.length;i < il;i++) {
			for (int j = 0,jl = il - i - 1; j < jl;j++) {
				if(rule == Enum.SORT_ASC){
					if (arr[j] > arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}else if(rule == Enum.SORT_DESC){
					if (arr[j] < arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}
			}
		}
	}
	
	/**
	 * 升序排列long数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:03
	 * @version v0.1
	 * @param arr
	 */
	public static void sortAsc(long[] arr){
		sort(arr, Enum.SORT_ASC);
	}
	
	/**
	 * 降序排列long数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:38
	 * @version v0.1
	 * @param arr
	 */
	public static void sortDesc(long[] arr){
		sort(arr, Enum.SORT_DESC);
	}
	
	/**
	 * 排列long数组，升序或降序
	 * @author Crow
	 * @date 2015年5月1日 上午11:17:48
	 * @version v0.1
	 * @param arr
	 * @param rule
	 */
	private static void sort(long[] arr, Enum rule){
		for (int i = 0,il = arr.length;i < il;i++) {
			for (int j = 0,jl = il - i - 1; j < jl;j++) {
				if(rule == Enum.SORT_ASC){
					if (arr[j] > arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}else if(rule == Enum.SORT_DESC){
					if (arr[j] < arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}
			}
		}
	}
	
	/**
	 * 升序排列short数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:03
	 * @version v0.1
	 * @param arr
	 */
	public static void sortAsc(short[] arr){
		sort(arr, Enum.SORT_ASC);
	}
	
	/**
	 * 降序排列short数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:38
	 * @version v0.1
	 * @param arr
	 */
	public static void sortDesc(short[] arr){
		sort(arr, Enum.SORT_DESC);
	}
	
	/**
	 * 排列short数组，升序或降序
	 * @author Crow
	 * @date 2015年5月1日 上午11:17:48
	 * @version v0.1
	 * @param arr
	 * @param rule
	 */
	private static void sort(short[] arr, Enum rule){
		for (int i = 0,il = arr.length;i < il;i++) {
			for (int j = 0,jl = il - i - 1; j < jl;j++) {
				if(rule == Enum.SORT_ASC){
					if (arr[j] > arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}else if(rule == Enum.SORT_DESC){
					if (arr[j] < arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}
			}
		}
	}
	
	/**
	 * 升序排列char数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:03
	 * @version v0.1
	 * @param arr
	 */
	public static void sortAsc(char[] arr){
		sort(arr, Enum.SORT_ASC);
	}
	
	/**
	 * 降序排列char数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:38
	 * @version v0.1
	 * @param arr
	 */
	public static void sortDesc(char[] arr){
		sort(arr, Enum.SORT_DESC);
	}
	
	/**
	 * 排列char数组，升序或降序
	 * @author Crow
	 * @date 2015年5月1日 上午11:17:48
	 * @version v0.1
	 * @param arr
	 * @param rule
	 */
	private static void sort(char[] arr, Enum rule){
		for (int i = 0,il = arr.length;i < il;i++) {
			for (int j = 0,jl = il - i - 1; j < jl;j++) {
				if(rule == Enum.SORT_ASC){
					if (arr[j] > arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}else if(rule == Enum.SORT_DESC){
					if (arr[j] < arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}
			}
		}
	}
	
	/**
	 * 升序排列byte数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:03
	 * @version v0.1
	 * @param arr
	 */
	public static void sortAsc(byte[] arr){
		sort(arr, Enum.SORT_ASC);
	}
	
	/**
	 * 降序排列byte数组
	 * @author Crow
	 * @date 2015年5月1日 上午11:19:38
	 * @version v0.1
	 * @param arr
	 */
	public static void sortDesc(byte[] arr){
		sort(arr, Enum.SORT_DESC);
	}
	
	/**
	 * 排列byte数组，升序或降序
	 * @author Crow
	 * @date 2015年5月1日 上午11:17:48
	 * @version v0.1
	 * @param arr
	 * @param rule
	 */
	private static void sort(byte[] arr, Enum rule){
		for (int i = 0,il = arr.length;i < il;i++) {
			for (int j = 0,jl = il - i - 1; j < jl;j++) {
				if(rule == Enum.SORT_ASC){
					if (arr[j] > arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}else if(rule == Enum.SORT_DESC){
					if (arr[j] < arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}
			}
		}
	}

	
	
	/*
	 * 交换数组中元素的方法
	 */
	/**
	 * 交换数组中两处索引位置的值
	 * @author Crow
	 * @date 2015年5月1日 上午10:23:29
	 * @version v0.1
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(Object[] arr, int a, int b) {
		Object tempObj = arr[a];
		arr[a] = arr[b];
		arr[b] = tempObj;
	}
	/**
	 * 交换int型数组中两处索引位置的值
	 * @author Crow
	 * @date 2015年5月1日 上午10:45:30
	 * @version v0.1
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * 交换double型数组中两处索引位置的值
	 * @author Crow
	 * @date 2015年5月1日 上午10:45:30
	 * @version v0.1
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(double[] arr, int a, int b){
		double temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * 交换float型数组中两处索引位置的值
	 * @author Crow
	 * @date 2015年5月1日 上午10:45:30
	 * @version v0.1
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(float[] arr, int a, int b){
		float temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * 交换long型数组中两处索引位置的值
	 * @author Crow
	 * @date 2015年5月1日 上午10:45:30
	 * @version v0.1
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(long[] arr, int a, int b){
		long temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * 交换short型数组中两处索引位置的值
	 * @author Crow
	 * @date 2015年5月1日 上午10:45:30
	 * @version v0.1
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(short[] arr, int a, int b){
		short temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * 交换char型数组中两处索引位置的值
	 * @author Crow
	 * @date 2015年5月1日 上午10:45:30
	 * @version v0.1
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(char[] arr, int a, int b){
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * 交换byte型数组中两处索引位置的值
	 * @author Crow
	 * @date 2015年5月1日 上午10:45:30
	 * @version v0.1
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(byte[] arr, int a, int b){
		byte temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
}
