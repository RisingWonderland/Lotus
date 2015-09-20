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
	public static final String PATTERN_TIME = "HH:mm:ss";
	public static final String PATTERN_MILLISECONDS = ".SSS";
	public static final String PATTERN_DATETIME = PATTERN_DATE + " " + PATTERN_TIME;
	
	public static final String PATTERN_TIME_EXACT = PATTERN_TIME + PATTERN_MILLISECONDS;
	public static final String PATTERN_DATETIME_EXACT = PATTERN_DATE + " " + PATTERN_TIME_EXACT;
	
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
		return getDatetimeStr(time, PATTERN_TIME_EXACT);
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
		return getDatetimeStr(time, PATTERN_TIME_EXACT, locale);
	}
	
	/**
	 * Return custom format date time string, just like "2012-12-12 12:12:12.999".
	 * @author Crow
	 * @date 2015年9月18日
	 * @param datetime
	 * @return
	 */
	public static String getDatetimeStr(Date datetime) {
		return getDatetimeStr(datetime, PATTERN_DATETIME_EXACT);
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
	 * Return a {@link Timestamp} from new date time.
	 * @author Crow
	 * @date 2015年9月20日
	 * @return
	 */
	public static Timestamp getTimestamp() {
		return getTimestamp(new Date());
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
	
	
	
	/**
	 * Return a {@link Calendar} instance.
	 * @author Crow
	 * @date 2015年9月20日
	 * @return
	 */
	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}
	
	/**
	 * Return a {@link Calendar} instance.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param datetime
	 * @return
	 */
	public static Calendar getCalendar(Date datetime) {
		return getCalendar(datetime, LOCALE_DEFAULT);
	}
	
	/**
	 * Return a {@link Calendar} instance.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param datetime
	 * @param locale
	 * @return
	 */
	public static Calendar getCalendar(Date datetime, Locale locale) {
		Calendar cal = Calendar.getInstance(locale);
		cal.setTime(datetime);
		return cal;
	}
	
	
	/**
	 * Get the time difference of two {@link Date}.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getTimeDifference(Date date1, Date date2) {
		if(CheckValid.checkIsNull(date1) || CheckValid.checkIsNull(date2)) {
			throw new IllegalArgumentException("Wrong, date parameter value can not be null.");
		}
		return date2.getTime() - date2.getTime();
	}
	
	
	
	/**
	 * Compare a {@link Date} and a date string.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(Date date, String dateStr) throws ParseException {
		return compareDate(date, dateStr, PATTERN_DATETIME);
	}
	
	/**
	 * Compare a {@link Date} and a date string.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(Date date, String dateStr, String pattern) throws ParseException {
		return compareDate(date, dateStr, pattern, LOCALE_DEFAULT);
	}
	
	/**
	 * Compare a {@link Date} and a date string.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @param dateStr
	 * @param pattern
	 * @param locale
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(Date date, String dateStr, String pattern, Locale locale) throws ParseException {
		return compareDate(date, getDate(dateStr, pattern, locale));
	}
	
	/**
	 * Compare two date string.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param dateStr1
	 * @param dateStr2
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(String dateStr1, String dateStr2) throws ParseException {
		return compareDate(dateStr1, dateStr2, PATTERN_DATETIME);
	}
	
	/**
	 * Compare two date string.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param dateStr1
	 * @param dateStr2
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(String dateStr1, String dateStr2, String pattern) throws ParseException {
		return compareDate(dateStr1, dateStr2, pattern, LOCALE_DEFAULT);
	}
	
	/**
	 * Compare two date string.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param dateStr1
	 * @param dateStr2
	 * @param pattern
	 * @param locale
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(String dateStr1, String dateStr2, String pattern, Locale locale) throws ParseException {
		return compareDate(getDate(dateStr1, pattern, locale), getDate(dateStr2, pattern, locale));
	}
	
	/**
	 * Compare two {@link Date}.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date1
	 * @param date2
	 * @return if 1, then date2 newer;
	 * if -1, then date1 newer;
	 * if 0, then they are the same date.
	 */
	public static int compareDate(Date date1, Date date2) {
		if(CheckValid.checkIsNull(date1) || CheckValid.checkIsNull(date2)) {
			throw new IllegalArgumentException("Wrong, date parameter value can not be null.");
		}
		
		if(date1.equals(date2)) {
			return 0;
		} else if(date1.before(date2)) {
			return -1;
		} else {
			return 1;
		}
	}
	
}
