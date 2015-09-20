package org.rw.crow.commons;

import static org.junit.Assert.fail;

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
	public void test() {
		
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
	

}
