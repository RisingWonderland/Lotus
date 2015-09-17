package org.rw.crow.regular;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	 * Check whether the file is a document, if it is not, then throw FileNotFoundException.
	 * @author Crow
	 * @date 2015年5月25日
	 * @version v0.1
	 * @param file
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static File checkNotDocument(File file) throws FileNotFoundException{
		if(!file.isFile()){
			throw new FileNotFoundException();
		}
		return file;
	}
	
	/**
	 * Check whether the file is exist.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param file
	 * @return
	 */
	public static boolean checkFileExist(File file) {
		if(file == null) {
			throw new IllegalArgumentException("No specified file.");
		}
		
		if(file.exists()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check whether the file is readable.
	 * @author Crow
	 * @date 2015年9月10日
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static boolean checkFileCanRead(File file) throws IOException{
		String fileName = file.getName();
		if(!checkFileExist(file)){
			throw new FileNotFoundException("File " + fileName + " not found.");
		}
		if(!file.canRead()){
			throw new IOException("File " + fileName + "can not be read.");
		}
		
		return true;
	}
	
	/**
	 * Check whether the file is writable.
	 * @author Crow
	 * @date 2015年9月10日
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static boolean checkFileCanEdit(File file) throws IOException{
		String fileName = file.getName();
		if(!checkFileExist(file)){
			throw new FileNotFoundException("File " + fileName + " not found.");
		}
		if(!file.canWrite()){
			throw new IOException("File " + fileName + "can not be write.");
		}
		
		return true;
	}
	
}
