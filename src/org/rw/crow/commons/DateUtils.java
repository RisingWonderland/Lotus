package org.rw.crow.commons;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.rw.crow.regular.CheckValid;

/**
 * Provides some methods for date.
 * @author Crow
 * @date 2015年9月18日
 *
 */
public class DateUtils {

	public static final String PATTERN_DATE = "yyyy-MM-dd";
	public static final String PATTERN_TIME = "HH:mm:ss.SSS";
	public static final String PATTERN_DATETIME = PATTERN_DATE + " " + PATTERN_TIME;
	
	public static final Locale LOCALE_DEFAULT = Locale.getDefault();
	
	
	/**
	 * Return a simple {@link SimpleDateFormat}.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param pattern
	 * @return
	 */
	public static SimpleDateFormat getSimpleDateFormat(String pattern) {
		CheckValid.checkStrIsNotNullAndEmpty(pattern);
		
		return new SimpleDateFormat(pattern);
	}
	
	/**
	 * Return a {@link SimpleDateFormat}, with {@link Locale} parameter.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param pattern
	 * @param locale
	 * @return
	 */
	public static SimpleDateFormat getSimpleDateFormat(String pattern, Locale locale) {
		CheckValid.checkStrIsNotNullAndEmpty(pattern);
		
		return new SimpleDateFormat(pattern, locale);
	}
	
	/**
	 * Return custom format date string, just like "2012-12-12".
	 * @author Crow
	 * @date 2015年9月18日
	 * @param date
	 * @param locale
	 * @return
	 */
	public static String getDateStr(Date date, Locale locale) {
		return getDatetimeStr(date, PATTERN_DATE, LOCALE_DEFAULT);
	}
	
	/**
	 * Return custom format date string, just like "2012-12-12".
	 * @author Crow
	 * @date 2015年9月18日
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date) {
		return getDatetimeStr(date, PATTERN_DATE);
	}
	
	/**
	 * Return custom format date string, just like "12:12:12.999".
	 * @author Crow
	 * @date 2015年9月18日
	 * @param time
	 * @return
	 */
	public static String getTimeStr(Date time) {
		return getDatetimeStr(time, PATTERN_TIME);
	}
	
	/**
	 * Return custom format date string, just like "12:12:12.999".
	 * @author Crow
	 * @date 2015年9月18日
	 * @param time
	 * @param locale
	 * @return
	 */
	public static String getTimeStr(Date time, Locale locale) {
		return getDatetimeStr(time, PATTERN_TIME, locale);
	}
	
	/**
	 * Return custom format date time string, just like "2012-12-12 12:12:12.999".
	 * @author Crow
	 * @date 2015年9月18日
	 * @param datetime
	 * @return
	 */
	public static String getDatetimeStr(Date datetime) {
		return getDatetimeStr(datetime, PATTERN_DATETIME);
	}
	
	/**
	 * Return custom format date time string, just like "2012-12-12 12:12:12.999".
	 * @author Crow
	 * @date 2015年9月18日
	 * @param datetime
	 * @param pattern
	 * @return
	 */
	public static String getDatetimeStr(Date datetime, String pattern) {
		return getDatetimeStr(datetime, pattern, LOCALE_DEFAULT);
	}
	
	/**
	 * Return custom format date time string, just like "2012-12-12 12:12:12.999".
	 * @author Crow
	 * @date 2015年9月18日
	 * @param datetime
	 * @param pattern
	 * @return
	 */
	public static String getDatetimeStr(Date datetime, String pattern, Locale locale) {
		return getSimpleDateFormat(pattern, locale).format(datetime);
	}
	
	
	/**
	 * Convert date time string to {@link Date}.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param dateStr date time string
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String dateStr) throws ParseException {
		return getDate(dateStr, PATTERN_DATETIME);
	}
	
	/**
	 * Convert date time string to {@link Date}.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param dateStr date time string
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String dateStr, String pattern) throws ParseException {
		return getDate(dateStr, pattern, LOCALE_DEFAULT);
	}
	
	/**
	 * Convert date time string to {@link Date}.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param dateStr date time string
	 * @param pattern custom format string
	 * @param locale
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String dateStr, String pattern, Locale locale) throws ParseException {
		return getSimpleDateFormat(pattern, locale).parse(dateStr);
	}
	
	
	/**
	 * Return a {@link Timestamp} from a {@link Date}.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param date
	 * @return
	 */
	public static Timestamp getTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	/**
	 * Return a {@link Timestamp} from a date time string.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp getTimestamp(String dateStr) throws ParseException {
		return new Timestamp(getDate(dateStr).getTime());
	}
	
	/**
	 * Return a {@link Timestamp} from a date time string.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp getTimestamp(String dateStr, String pattern) throws ParseException {
		return new Timestamp(getDate(dateStr, pattern).getTime());
	}
	
	/**
	 * Return a {@link Timestamp} from a date time string.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param dateStr
	 * @param pattern
	 * @param locale
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp getTimestamp(String dateStr, String pattern, Locale locale) throws ParseException {
		return new Timestamp(getDate(dateStr, pattern, locale).getTime());
	}
	
	
	/**
	 * Return milliseconds from a date time string.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param dateStr
	 * @param pattern
	 * @param locale
	 * @return
	 * @throws ParseException
	 */
	public static long getMilliseconds(String dateStr, String pattern, Locale locale) throws ParseException {
		return getDate(dateStr, pattern, locale).getTime();
	}
	
	
//	public static Calendar getCalendar(Date datetime, Locale locale) {
//		
//	}
	
}
