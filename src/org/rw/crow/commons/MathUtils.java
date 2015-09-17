package org.rw.crow.commons;

import java.math.BigDecimal;

/**
 * Provides some methods for mathematics.
 * @author Crow
 * @date 2015年9月17日
 *
 */
public class MathUtils {

	
	/**
	 * Correct the result to the 2 decimal places.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param num
	 * @return
	 */
	public static double precisionTwoplaceDecimal(double num) {
		return precisionDecimal(num, 2);
	}
	
	/**
	 * Correct the result to the specified digit decimal places.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param num
	 * @param digit
	 * @return
	 */
	public static double precisionDecimal(double num, int digit) {
		if(digit < 0){
			throw new IllegalArgumentException("Wrong, the value of \"digit\" must be >= 0.");
		}
		
		BigDecimal bd = new BigDecimal(num);
		return bd.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
}
