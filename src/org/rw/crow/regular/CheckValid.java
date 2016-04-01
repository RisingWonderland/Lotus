package org.rw.crow.regular;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Check parameter validity
 * @author Crow
 * @date 2015年5月11日
 * @version v0.1
 */
public class CheckValid {

	// ensuring cannot instantiate
	private CheckValid(){}
	
	/**
	 * Check whether the parameter is null.
	 * @author Crow
	 * @date 2015年5月11日
	 * @version v0.1
	 * @param obj the parameter we checked
	 * @return true is the parameter which we checked is null
	 */
	public static <T> boolean checkIsNull(T obj){
		if(obj == null){
			return true;
		}
		return false;
	}
	
	/**
	 * Check whether the parameter is null, if it is, then throw NullPointerException.
	 * @author Crow
	 * @date 2015年5月11日
	 * @version v0.1
	 * @param obj
	 * @return the non-null parameter
	 * @throws NullPointerException if the parameter which we checked is null 
	 */
	public static <T> T checkNotNull(T obj){
		if(obj == null){
			throw new NullPointerException();
		}
		return obj;
	}
	
	
	public static boolean checkIsDocument(File file){
		if(file.isFile()){
			return true;
		}
		return false;
	}
	
	/**
	 * Check whether the file is a document, if it is, then throw FileNotFoundException.
	 * @author Crow
	 * @date 2015年5月25日
	 * @version v0.1
	 * @param file
	 * @return
	 */
	public static File checkNotDocument(File file){
		if(!file.isFile()){
			try {
				throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
}
