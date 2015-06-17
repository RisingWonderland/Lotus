package org.rw.crow.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

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
	 * @version v0.2
	 * @param file file to be opened for writing
	 * @param content the content to be written  
	 * @return
	 */
	public static boolean write(File file, Object content){
		return write(file, content, Charset.forName("UTF-8"), true);
	}
	
	/**
	 * Writes string content into a file.
	 * @author Crow
	 * @date 2015年5月25日
	 * @version v0.2
	 * @param file file to be opened for writing
	 * @param content the content to be written  
	 * @return
	 */
	public static boolean write(File file, Object content, boolean append){
		return write(file, content, Charset.forName("UTF-8"), append);
	}
	
	/**
	 * Writes string content into a file.
	 * @author Crow
	 * @date 2015年6月17日
	 * @version v0.1
	 * @param file > the file to be opened for writing
	 * @param content > the content to be written  
	 * @param cs > default UTF-8
	 * @param append if true, the content will be written to the end of the file rather than the beginning
	 * @return
	 */
	public static boolean write(File file, Object content, Charset cs, boolean append){
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream(file, append), cs);
			bw = new BufferedWriter(osw);
			bw.write(content.toString());
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(bw != null) bw.close();
				if(osw != null) osw.close();
			} catch (IOException e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
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
	
	/**
	 * Copy a file.
	 * @author Crow
	 * @date 2015年6月17日
	 * @version v0.1
	 * @param sourceFile the original file.
	 * @param targetFile the new generated file.
	 */
	public static void copyFile(File sourceFile, File targetFile){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			 fis = new FileInputStream(sourceFile);
			 fos = new FileOutputStream(targetFile);
			 byte[] buffer = new byte[1024];
			 int length = 0;
			 while((length = fis.read(buffer)) != -1){
				 fos.write(buffer, 0, length);
			 }
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
				if(fis != null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Delete file.
	 * @author Crow
	 * @date 2015年6月17日
	 * @version v0.2
	 * @param file	the file to be deleted.
	 * @param force	if true, and the file is a non-empty folder, still delete.
	 * @return
	 */
	public static boolean delete(File file, boolean force){
		if(!force){
			return file.delete();
		}
		
		// 判断file对象类型
		// 如果file是文件，跳过if，删除；
		// 如果是文件夹，进入if，遍历删除内部资料，再删除空文件夹
		if(file.isDirectory()){
			String[] filePaths = file.list();
			for(String childPath : filePaths){
				if(!delete(new File(file, childPath), force)){
					return false;
				}
			}
		}
		
		return file.delete();
	}
}
