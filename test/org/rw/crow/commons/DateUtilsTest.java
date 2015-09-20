package org.rw.crow.commons;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rw.crow.regular.CheckValid;

import com.sun.jmx.snmp.Timestamp;

public class DateUtilsTest {

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
	public void test() throws ParseException {
		Date d1 = DateUtils.getDate("2012-12-12 12:12:12");
		Date d2 = DateUtils.getDate("2014-12-12 12:12:12");
		System.out.println(d1.after(d2));
		System.out.println(d1.before(d2));
		System.out.println(d1.equals(d2));
		
		System.out.println(DateUtils.getTimeStr(new Date()));
	}
	
	@Test
	public void testGetDatetimeStr() {
		System.out.println(DateUtils.getDatetimeStr(new Date()));
		System.out.println(DateUtils.getDatetimeStr(new Date(), DateUtils.PATTERN_DATETIME));
	}
	
	@Test
	public void testGetCalendar() {
		Calendar cal = DateUtils.getCalendar();
		System.out.println(cal.getTimeInMillis());
		System.out.println(cal.getTime());
	}
	
	@Test
	public void testCompareDate() throws ParseException {
		Date d1 = DateUtils.getDate("2012-12-12 12:12:12");
		Date d2 = DateUtils.getDate("2014-12-12 12:12:12");
		
		System.out.println(DateUtils.compareDate(d1, d2));
	}
	

}
