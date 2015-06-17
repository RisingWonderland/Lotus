package org.rw.crow.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.rw.crow.regular.CheckValid;

/**
 * Provides some methods for manipulate files.
 * 
 * All method parameters must be non-null in the default situation.
 * @author Crow
 * @date 2015年5月11日
 * @version v0.1
 */
public class FileUtils {

	// ensuring cannot instantiate
	private FileUtils(){}
	
	
	/**
	 * Traverse files and directories within the target file.
	 * @author Crow
	 * @date 2015年5月25日
	 * @version v0.1
	 * @param dirFile the directory we iterated
	 */
	public static void iterateDir(File dirFile){
		File[] files = dirFile.listFiles();
		for(File file : files){
			if(file.isFile()){
				System.out.println(file.getAbsolutePath().toString());
			}else{
				iterateDir(file);
			}
		}
	}
	
	/**
	 * Writes string content to append to a file.
	 * @author Crow
	 * @date 2015年5月25日
	 * @version v0.1
	 * @param file the file we want to write
	 * @param content the content we wrote
	 */
	public static void write(File file, Object content){
		write(file, content, true);
	}
	
	/**
	 * Writes string content into a file.
	 * @author Crow
	 * @date 2015年5月25日
	 * @version v0.1
	 * @param file the file we want to write
	 * @param content the content we wrote
	 */
	public static void write(File file, Object content, boolean append){
		FileOutputStream fos = null;
		try {
			 fos = new FileOutputStream(file, append);
			 byte[] data = content.toString().getBytes();
			 fos.write(data);
			 fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Read all the contents of a text file.
	 * @author Crow
	 * @date 2015年5月25日
	 * @version v0.1
	 * @param file
	 * @return
	 */
	public static String readEntrieFile(File file){
		CheckValid.checkNotDocument(file);
		if(!CheckValid.checkIsDocument(file)) return "";
		
		StringBuilder sbd = new StringBuilder();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			is = new FileInputStream(file);
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			char[] data = new char[1024];
			int len = 0;
			while((len = br.read(data)) != -1){
				sbd.append(String.valueOf(data, 0, len));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is != null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sbd.toString();
	}
	
}
