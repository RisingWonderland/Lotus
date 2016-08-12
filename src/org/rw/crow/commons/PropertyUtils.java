package org.rw.crow.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 * Provides some methods for properties.
 * @author Crow
 * @date 2015年9月12日
 *
 */
public class PropertyUtils {
	
	private PropertyUtils(){}
	
	
	/**
	 * Get property file input stream. 
	 * @author Crow
	 * @date 2015年9月12日
	 * @param propertyPath
	 * @return
	 */
	public static InputStream getPropertyStream(String propertyPath) {
		return Object.class.getResourceAsStream(propertyPath);
	}
	
	/**
	 * Get property value from properties.
	 * @author Crow
	 * @date 2015年9月12日
	 * @param propertyPath
	 * @param key
	 * @return
	 */
	public static String getProperty(String propertyPath, String key) {
		return getProperty(propertyPath, key);
	}
	
	/**
	 * Get property value from properties.
	 * @author Crow
	 * @date 2015年9月12日
	 * @return
	 */
	public static String getProperty(String propertyPath, String key, String defaultValue) {
		String value = null;
		Properties props = new Properties();
		InputStream is = getPropertyStream(propertyPath);
		if(is != null){
			try {
				props.load(is);
				value = props.getProperty(key, defaultValue);
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}
	
	/**
	 * Get all properties from properties.
	 * @author Crow
	 * @date 2015年9月12日
	 * @param propertyPath
	 * @return
	 */
	public static HashMap<String, String> getAllProperty(String propertyPath) {
		HashMap<String, String> map = new HashMap<String, String>();
		Properties props = new Properties();
		InputStream is = getPropertyStream(propertyPath);
		if(is != null){
			try {
				props.load(is);
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Enumeration<Object> keys = props.keys();
			while(keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				map.put(key, props.getProperty(key));
			}
		}
		
		return map;
	}
	
}
