package org.rw.crow.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;

import org.rw.crow.commons.PathUtils;
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
	
	private final static int BUFFER_SIZE = 1024;
	// file attributes
	private final static String READ_ONLY = "readOnly";
	private final static String CAN_WRITE = "canWrite";
	private final static String HIDDEN = "hidden";
	private final static String VISIBLE = "visible";
	

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
	 * Check whether the directory is empty.
	 * @author Crow
	 * @date 2015年9月9日
	 * @param file the directory to be checked
	 * @throws IOException 
	 */
	public static boolean isDirEmpty(File file) throws IOException {
		CheckValid.checkFileCanRead(file);
		
		if(file.listFiles().length == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Check whether only the files within the directory.
	 * @author Crow
	 * @date 2015年9月9日
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static boolean isDirWithoutDir(File file) throws IOException{
		CheckValid.checkFileCanRead(file);
		
		File[] files = file.listFiles();
		for(File tFile : files){
			if(tFile.isDirectory()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Make the parent directory.
	 * @author Crow
	 * @date 2015年9月11日
	 * @param file
	 * @return parent directory path string
	 */
	public static String mkParentDirs(File file){
		File parent = file.getParentFile();
		if(parent != null && !parent.exists()){
			parent.mkdirs();
		}
		return parent.getAbsolutePath().toString();
	}
	
	/**
	 * Make the parent directory.
	 * @author Crow
	 * @date 2015年9月11日
	 * @param path
	 * @return parent directory path string.
	 */
	public static String mkParentDirs(String path){
		return mkParentDirs(new File(path));
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
	 * Appends content to the front of a file.
	 * @author Crow
	 * @date 2015年9月10日
	 * @param file
	 * @param content
	 * @return
	 */
	public static boolean writePreviousAppend(File file, Object content){
		// 获取原文件内容
		String sourceContent = readTextFile(file);
		String result = content.toString() + "\r\n" + sourceContent;
		
		// 向目标文件覆写内容
		write(file, result, false);
		
		return false;
	}
	
	/**
	 * Read all the contents of a text file.
	 * @author Crow
	 * @date 2015年5月25日
	 * @version v0.1
	 * @param file
	 * @return
	 */
	public static String readTextFile(File file){
		try {
			CheckValid.checkNotDocument(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			
			return "";
		}
		
		StringBuilder sbd = new StringBuilder();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			is = new FileInputStream(file);
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			char[] data = new char[BUFFER_SIZE];
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
				if(is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sbd.toString();
	}
	
	/**
	 * Get the first line content of the file.
	 * @author Crow
	 * @date 2015年9月9日
	 * @param file
	 * @return
	 */
	public static String readFirstLine(File file){
		String firstLine = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			firstLine = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null){
					br.close();
				}
				if(fr != null){
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return firstLine;
	}
	
	/**
	 * Get the first line of the file which line is not empty string.
	 * @author Crow
	 * @date 2015年9月9日
	 * @param file
	 * @return
	 */
	public static String readFirstNonEmptyLine(File file){
		String firstLine = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			firstLine = br.readLine();
			while(firstLine != null){
				if(!firstLine.equals("")){
					return firstLine;
				}
				firstLine = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return firstLine;
	}
	
	/**
	 * Get the last line of the file.
	 * @author Crow
	 * @date 2015年9月9日
	 * @param file
	 * @return
	 */
	public static String readLastLine(File file){
		String lastLine = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null){
				lastLine = line;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return lastLine;
	}
	
	/**
	 * Get the last line of the file which line is not empty string.
	 * @author Crow
	 * @date 2015年9月9日
	 * @param file
	 * @return
	 */
	public static String readLastNonEmptyLine(File file){
		String lastLine = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null){
				if(!line.equals("")){
					lastLine = line;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return lastLine;
	}
	
	/**
	 * Set attributes for a file.
	 * @author Crow
	 * @date 2015年9月7日
	 * @param file
	 * @param attr
	 * @throws IOException 
	 */
	public static void setAttribute(File file, String attr) throws IOException{
		String param = null;
		switch (attr) {
		case READ_ONLY:
			param = "+R";
			break;
		case CAN_WRITE:
			param = "-R";
			break;
		case HIDDEN:
			param = "+H";
			break;
		case VISIBLE:
			param = "-H";
			break;
		default:
			throw new IOException("Wrong param.");
		}
		String cmd = "attrib \"" + file.getAbsolutePath().toString() + "\" " + param;
		
		Runtime.getRuntime().exec(cmd);
	}
	
	
	/**
	 * Copy a file or folder.
	 * @author Crow
	 * @date 2015年9月6日
	 * @param sourceFile
	 * @param targetFile
	 * @throws IOException 
	 */
	public static void copy(File sourceFile, File targetFile) throws IOException{
		copy(sourceFile, targetFile, false, false);
	}
	
	/**
	 * Copy a file or folder, and you can decide whether to overwrite the target file.
	 * @author Crow
	 * @date 2015年9月6日
	 * @param sourceFile
	 * @param targetFile
	 * @param overwrite
	 * @throws IOException 
	 */
	public static void copy(File sourceFile, File targetFile, boolean overwrite) throws IOException{
		copy(sourceFile, targetFile, true, false);
	}
	
	/**
	 * Copy a file or folder.
	 * 
	 * 检测时文件或文件夹
	 * 如果是文件，更新sourceFile和targetFile，复制
	 * 如果是文件夹，更新两个file变量值，创建文件夹
	 * 
	 * @author Crow
	 * @date 2015年6月17日
	 * @version v0.3
	 * @param sourceFile the original file.
	 * @param targetFile the new generated file.
	 * @param overwrite if true, and if the target file already exist, then overwrite it.
	 * @param deleteSourceFile if true, delete the source file after it has been copied.
	 * @throws IOException 
	 */
	public static void copy(File sourceFile, File targetFile, boolean overwrite, boolean deleteSourceFile) throws IOException{
		CheckValid.checkFileCanRead(sourceFile);
		
		// 如果目标文件是文件夹，并且重名，在overwrite为false的情况下所有文件都不能复制
		if(!overwrite && targetFile.exists()){
			throw new FileAlreadyExistsException("File " + targetFile.getName() + 
					" already exist, unable to overwrite it. "
					+ "So if you want to overwrite it, "
					+ "please set the \"overwrite\" property value is true.");
		}
		
		/*
		 * 如果原文件是文件夹，递归；
		 * 如果原文件是文件，复制。
		 */
		if(sourceFile.isDirectory()){
			// 创建目标文件夹
			targetFile.mkdirs();
			// 更新file变量
			File tSourceFile = null;
			File tTargetFile = null;
			File[] fileList = sourceFile.listFiles();
			for(File file : fileList){
				tSourceFile = file;
				if(file.isDirectory()){
					String tTargetFileName = PathUtils.getDirPath(targetFile.getAbsolutePath().toString(), file.getName());
					tTargetFile = new File(tTargetFileName);
				}else{
					String tTargetFileName = PathUtils.getFilePath(file.getName(), targetFile.getAbsolutePath().toString());
					tTargetFile = new File(tTargetFileName);
				}
				
				copy(tSourceFile, tTargetFile, true, false);
			}
		}else{
			// 执行复制操作
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				fis = new FileInputStream(sourceFile);
				fos = new FileOutputStream(targetFile);
				copy(fis, fos);
				fos.flush();
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
		
		// 判断并设置隐藏属性
		if(sourceFile.isHidden()){
			setAttribute(targetFile, HIDDEN);
		}
		
		// 判断并删除原文件
		if(deleteSourceFile){
			delete(sourceFile, true);
		}
	}
	
	/**
	 * Copy data from input stream to output stream.
	 * @author Crow
	 * @date 2015年9月2日
	 * @param is data source
	 * @param os data output destination
	 */
	public static void copy(InputStream is, OutputStream os){
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			int length = 0;
			while((length = is.read(buffer)) != -1){
				os.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Move a file or folder.
	 * @author Crow
	 * @date 2015年9月6日
	 * @param sourceFile
	 * @param targetFile
	 * @throws IOException 
	 */
	public static void move(File sourceFile, File targetFile) throws IOException{
		copy(sourceFile, targetFile, false, true);
	}
	
	/**
	 * Move a file or folder, and you can decide whether to overwrite the target file.
	 * @author Crow
	 * @date 2015年9月6日
	 * @param sourceFile
	 * @param targetFile
	 * @param overwrite
	 * @throws IOException 
	 */
	public static void move(File sourceFile, File targetFile, boolean overwrite) throws IOException{
		copy(sourceFile, targetFile, overwrite, true);
	}
	
	/**
	 * Delete file or folder.
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
	
	/**
	 * Clear all file and folder inner the folder.
	 * @author Crow
	 * @date 2015年9月7日
	 * @param file
	 * @return
	 */
	public static boolean clearFoler(File file){
		if(delete(file, true)){
			return file.mkdirs();
		}
		return false;
	}
	
	/**
	 * Delete all files in the folder.
	 * @author Crow
	 * @date 2015年9月7日
	 * @param file
	 */
	public static void clearAllFileInFolder(File file){
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File tFile : files){
				clearAllFileInFolder(tFile);
			}
		}else{
			file.delete();
		}
	}
	
	/**
	 * Delete all files in the first level folder, if the file object is a file, delete it.
	 * If any file delete failed, then return false and method stop running.
	 * @author Crow
	 * @date 2015年9月11日
	 * @param file
	 * @return
	 */
	public static boolean clearAllFileInFirstLevelFolder(File file){
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File tFile : files){
				if(tFile.isFile()){
					if(!tFile.delete()) return false;
				}
			}
		}else{
			file.delete();
		}
		return true;
	}
}
