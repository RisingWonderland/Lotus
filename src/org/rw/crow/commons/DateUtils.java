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
	 * Return year.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		return getCalendar(date).get(Calendar.YEAR);
	}
	
	/**
	 * Return year from now date.
	 * @author Crow
	 * @date 2015年9月20日
	 * @return
	 */
	public static int getYearNow() {
		return getCalendar(new Date()).get(Calendar.YEAR);
	}
	
	/**
	 * Return month.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return 0-11
	 */
	public static int getMonth(Date date) {
		return getCalendar(date).get(Calendar.MONTH);
	}
	
	/**
	 * Return month from now date.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getMonthNow() {
		return getCalendar(new Date()).get(Calendar.MONTH);
	}
	
	/**
	 * Return day of year.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getDayOfYear(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_YEAR);
	}
	
	/**
	 * Return day of year from now date.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getDayOfYearNow() {
		return getCalendar(new Date()).get(Calendar.DAY_OF_YEAR);
	}
	
	/**
	 * Return day of month.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Return day of month from now date.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getDayOfMonthNow() {
		return getCalendar(new Date()).get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Return day of week.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return 1 --> Sunday
	 */
	public static int getDayOfWeek(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Return day of week from now date.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getDayOfWeekNow() {
		return getCalendar(new Date()).get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Return hour12.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getHour12(Date date) {
		return getCalendar(date).get(Calendar.HOUR);
	}
	
	/**
	 * Return hour12 from now date.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getHour12Now() {
		return getCalendar(new Date()).get(Calendar.HOUR);
	}
	
	/**
	 * Return hour24.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getHour24(Date date) {
		return getCalendar(date).get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Return hour24 from now date.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getHour24Now() {
		return getCalendar(new Date()).get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Return minute from a {@link Date}.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		return getCalendar(date).get(Calendar.MINUTE);
	}
	
	/**
	 * Return minute from now date.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getMinuteNow() {
		return getCalendar().get(Calendar.MINUTE);
	}
	
	/**
	 * Return second from a {@link Date}.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getSecond(Date date) {
		return getCalendar(date).get(Calendar.SECOND);
	}
	
	/**
	 * Return second from now date.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getSecondNow() {
		return getCalendar().get(Calendar.SECOND);
	}
	
	/**
	 * Return millisecond from a {@link Date}.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @return
	 */
	public static int getMillisecond(Date date) {
		return getCalendar(date).get(Calendar.MILLISECOND);
	}
	
	/**
	 * Return millisecond from a {@link Date}.
	 * @author Crow
	 * @date 2015年9月20日
	 * @return
	 */
	public static int getMillisecondNow() {
		return getCalendar(new Date()).get(Calendar.MILLISECOND);
	}
	
	
	
	/**
	 * Get the specified time according to the date and time difference.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param date
	 * @param unit Calendar.YEAR...
	 * @param diff time difference
	 * @return
	 */
	public static Date getDateByTimeDiff(Date date, int unit, int diff) {
		if(CheckValid.checkIsNull(date)) {
			throw new IllegalArgumentException("Wrong, date parameter value can not be null.");
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch(unit) {
		case Calendar.YEAR: 
			cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + diff);
			break;
		case Calendar.MONTH: 
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + diff);
			break;
		case Calendar.DAY_OF_MONTH: 
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + diff);
			break;
		case Calendar.DAY_OF_WEEK: 
			cal.set(Calendar.DAY_OF_WEEK, cal.get(Calendar.DAY_OF_WEEK) + diff);
			break;
		case Calendar.DAY_OF_WEEK_IN_MONTH: 
			cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) + diff);
			break;
		case Calendar.HOUR: 
			cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + diff);
			break;
		case Calendar.HOUR_OF_DAY: 
			cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + diff);
			break;
		case Calendar.MINUTE: 
			cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + diff);
			break;
		case Calendar.SECOND: 
			cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) + diff);
			break;
		case Calendar.MILLISECOND: 
			cal.set(Calendar.MILLISECOND, cal.get(Calendar.MILLISECOND) + diff);
			break;
		}
		
		return cal.getTime();
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
