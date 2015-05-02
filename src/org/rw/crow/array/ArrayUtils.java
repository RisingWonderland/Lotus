package org.rw.crow.array;

/**
 * Contains some methods about arrays.
 * @author Crow
 * @date 2015年5月1日
 * @version v0.1
 */
public class ArrayUtils {
	
	/**
	 * Prevents instantiation.
	 */
	private ArrayUtils(){}
	
	/**
	 * Get the minimum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the minimum and maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we used
	 * @return an array that contains only two extreme elements just like [minimum, maximum]
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
	 * Get the minimum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the minimum and maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we used
	 * @return an array that contains only two extreme elements just like [minimum, maximum]
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
	 * Get the minimum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the minimum and maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we used
	 * @return an array that contains only two extreme elements just like [minimum, maximum]
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
	 * Get the minimum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the minimum and maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we used
	 * @return an array that contains only two extreme elements just like [minimum, maximum]
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
	 * Get the minimum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the minimum and maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we used
	 * @return an array that contains only two extreme elements just like [minimum, maximum]
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
	 * Get the minimum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the minimum and maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we used
	 * @return an array that contains only two extreme elements just like [minimum, maximum]
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
	 * Get the minimum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
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
	 * Get the minimum and maximum from the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we used
	 * @return an array that contains only two extreme elements just like [minimum, maximum]
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
	 * Exchange two elements in an array.
	 */
	
	/**
	 * Swaps arr[a] with arr[b] in the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we need to manipulate
	 * @param a
	 * @param b
	 */
	public static void swap(Object[] arr, int a, int b) {
		Object tempObj = arr[a];
		arr[a] = arr[b];
		arr[b] = tempObj;
	}
	/**
	 * Swaps arr[a] with arr[b] in the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we need to manipulate
	 * @param a
	 * @param b
	 */
	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * Swaps arr[a] with arr[b] in the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we need to manipulate
	 * @param a
	 * @param b
	 */
	public static void swap(double[] arr, int a, int b){
		double temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * Swaps arr[a] with arr[b] in the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we need to manipulate
	 * @param a
	 * @param b
	 */
	public static void swap(float[] arr, int a, int b){
		float temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * Swaps arr[a] with arr[b] in the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we need to manipulate
	 * @param a
	 * @param b
	 */
	public static void swap(long[] arr, int a, int b){
		long temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * Swaps arr[a] with arr[b] in the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we need to manipulate
	 * @param a
	 * @param b
	 */
	public static void swap(short[] arr, int a, int b){
		short temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * Swaps arr[a] with arr[b] in the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we need to manipulate
	 * @param a
	 * @param b
	 */
	public static void swap(char[] arr, int a, int b){
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * Swaps arr[a] with arr[b] in the specified array.
	 * @author Crow
	 * @date 2015年5月1日
	 * @version v0.1
	 * @param arr the array we need to manipulate
	 * @param a
	 * @param b
	 */
	public static void swap(byte[] arr, int a, int b){
		byte temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	/**
	 * Reverses the specified array.
	 * @author Crow
	 * @date 2015年5月2日
	 * @version v0.1
	 * @param arr the array to be reversed
	 */
	public static void reverse(Object[] arr){
		int len = arr.length;
		if(len == 0) return;
		
		for(int i = len - 1, l = (len - 1) / 2; i > l; i--){
			swap(arr, i, len - 1 - i);
		}
	}
	/**
	 * Reverses the specified array.
	 * @author Crow
	 * @date 2015年5月2日
	 * @version v0.1
	 * @param arr the array to be reversed
	 */
	public static void reverse(int[] arr){
		int len = arr.length;
		if(len == 0) return;
		
		for(int i = len - 1, l = (len - 1) / 2; i > l; i--){
			swap(arr, i, len - 1 - i);
		}
	}
	/**
	 * Reverses the specified array.
	 * @author Crow
	 * @date 2015年5月2日
	 * @version v0.1
	 * @param arr the array to be reversed
	 */
	public static void reverse(double[] arr){
		int len = arr.length;
		if(len == 0) return;
		
		for(int i = len - 1, l = (len - 1) / 2; i > l; i--){
			swap(arr, i, len - 1 - i);
		}
	}
	/**
	 * Reverses the specified array.
	 * @author Crow
	 * @date 2015年5月2日
	 * @version v0.1
	 * @param arr the array to be reversed
	 */
	public static void reverse(float[] arr){
		int len = arr.length;
		if(len == 0) return;
		
		for(int i = len - 1, l = (len - 1) / 2; i > l; i--){
			swap(arr, i, len - 1 - i);
		}
	}
	/**
	 * Reverses the specified array.
	 * @author Crow
	 * @date 2015年5月2日
	 * @version v0.1
	 * @param arr the array to be reversed
	 */
	public static void reverse(long[] arr){
		int len = arr.length;
		if(len == 0) return;
		
		for(int i = len - 1, l = (len - 1) / 2; i > l; i--){
			swap(arr, i, len - 1 - i);
		}
	}
	/**
	 * Reverses the specified array.
	 * @author Crow
	 * @date 2015年5月2日
	 * @version v0.1
	 * @param arr the array to be reversed
	 */
	public static void reverse(short[] arr){
		int len = arr.length;
		if(len == 0) return;
		
		for(int i = len - 1, l = (len - 1) / 2; i > l; i--){
			swap(arr, i, len - 1 - i);
		}
	}
	/**
	 * Reverses the specified array.
	 * @author Crow
	 * @date 2015年5月2日
	 * @version v0.1
	 * @param arr the array to be reversed
	 */
	public static void reverse(char[] arr){
		int len = arr.length;
		if(len == 0) return;
		
		for(int i = len - 1, l = (len - 1) / 2; i > l; i--){
			swap(arr, i, len - 1 - i);
		}
	}
	/**
	 * Reverses the specified array.
	 * @author Crow
	 * @date 2015年5月2日
	 * @version v0.1
	 * @param arr the array to be reversed
	 */
	public static void reverse(byte[] arr){
		int len = arr.length;
		if(len == 0) return;
		
		for(int i = len - 1, l = (len - 1) / 2; i > l; i--){
			swap(arr, i, len - 1 - i);
		}
	}
	
	
	
	
	
	
}
