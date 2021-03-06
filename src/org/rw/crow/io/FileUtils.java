package org.rw.crow.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.util.Date;
import java.util.HashMap;

import org.rw.crow.commons.ConstantUtils;
import org.rw.crow.commons.MathUtils;
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
	
	private static final int BUFFER_SIZE = 1024;
	// file attributes
	private static final String READ_ONLY = "readOnly";
	private static final String CAN_WRITE = "canWrite";
	private static final String HIDDEN = "hidden";
	private static final String VISIBLE = "visible";
	
	private static final Charset UTF8 = Charset.forName("UTF-8");
	

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
	 * @param directory the directory to be checked
	 * @throws IOException 
	 */
	public static boolean isDirEmpty(File directory) throws IOException {
		CheckValid.checkFileCanRead(directory);
		
		if(directory.listFiles().length == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Check whether only the files within the directory.
	 * @author Crow
	 * @date 2015年9月9日
	 * @param directory
	 * @return
	 * @throws IOException 
	 */
	public static boolean isDirWithoutDir(File directory) throws IOException{
		CheckValid.checkFileCanRead(directory);
		
		File[] files = directory.listFiles();
		for(File tFile : files){
			if(tFile.isDirectory()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check whether only folders with in the directory.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param directory
	 * @return
	 * @throws IOException
	 */
	public static boolean isDirAloneDir(File directory) throws IOException {
		CheckValid.checkFileCanRead(directory);
		
		if(!CheckValid.checkFileIsDirectory(directory)) {
			throw new IOException("File is not directory: " + directory.getAbsolutePath().toString());
		}
		
		if(statsFileCount(directory) > 0) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Statistics of the number of files and folders.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static int statsFileObjCount(File file) throws IOException {
		CheckValid.checkFileCanRead(file);
		
		if(file.isDirectory()) {
			int count = 1;
			File[] files = file.listFiles();
			for(File tFile : files) {
				count += statsFileObjCount(tFile);
			}
			return count;
		} else {
			return 1;
		}
	}
	
	/**
	 * Statistics of the number of files.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static int statsFileCount(File file) throws IOException {
		CheckValid.checkFileCanRead(file);
		
		if(file.isDirectory()) {
			int count = 0;
			File[] files = file.listFiles();
			for(File tFile : files) {
				count += statsFileCount(tFile);
			}
			return count;
		} else {
			return 1;
		}
	}
	
	/**
	 * Statistics of the number of the folders, include the specified folder itself.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param directory
	 * @return number of the folders, include the specified folder itself.
	 * @throws IOException
	 */
	public static int statsFolderCount(File directory) throws IOException {
		CheckValid.checkFileCanRead(directory);
		
		if(directory.isDirectory()) {
			int count = 1;
			File[] files = directory.listFiles();
			for(File tFile : files) {
				count += statsFolderCount(tFile);
			}
			return count;
		}
		
		return 0;
	}
	
	/**
	 * Close IO stream safely.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param stream
	 */
	public static void closeStream(Closeable stream) {
		try {
			if(stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			System.out.println("Close IO stream failure.");
			e.printStackTrace();
		}
	}
	
	public static void closeStreams(Closeable... streams) {
		try {
			for(Closeable stream : streams) {
				if(stream != null) {
					stream.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Close IO stream failure.");
			e.printStackTrace();
		}
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
	 * Construct a {@link File} object from the collection of path elements.
	 * From apache.commons.io.FileUtils.
	 * @author Crow
	 * @date 2015年9月12日
	 * @param paths the elements of file path
	 * @return
	 */
	public static File getFile(String... paths) {
		if(paths == null){
			throw new NullPointerException("paths must not be null");
		}
		
		File file = null;
		for(String path : paths){
			if(file == null){
				file = new File(path);
			}else{
				file = new File(file, path);
			}
		}
		
		return file;
	}
	
	/**
	 * Construct a {@link File} from the collection of path elements.
	 * From apache.commons.io.FileUtils.
	 * @author Crow
	 * @date 2015年9月12日
	 * @param dir the parent directory
	 * @param paths the elements of file path
	 * @return
	 */
	public static File getFile(File dir, String... paths){
		if(dir == null){
			throw new NullPointerException("dir must not be null");
		}
		if(paths == null){
			throw new NullPointerException("paths must not be null");
		}
		
		for(String path : paths){
			dir = new File(dir, path);
		}
		return dir;
	}
	
	/**
	 * Get the path of user's home directory.
	 * @author Crow
	 * @date 2015年9月12日
	 * @return
	 */
	public static String getUserDirPath() {
		return System.getProperty("user.home");
	}
	
	/**
	 * Get a {@link File} of user's home directory.
	 * @author Crow
	 * @date 2015年9月12日
	 * @return
	 */
	public static File getUserDirFile() {
		return new File(getUserDirPath());
	}
	
	/**
	 * Get file or folder size.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static long getSize(File file) throws IOException {
		CheckValid.checkFileCanRead(file);
		
		if(file.isDirectory()) {
			long size = 0;
			File[] files = file.listFiles();
			for(File tFile : files) {
				size += getSize(tFile);
			}
			return size;
		} else {
			return file.length();
		}
	}
	
	/**
	 * File size unit convert.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param size size to convert, byte
	 * @param digit
	 * @return
	 */
	public static String sizeConvert(double size, String unit, int digit) {
		// 检测接收到的单位是否合法
		if(unit == null || unit.equals("")) {
			throw new IllegalArgumentException("Parameter \"unit\" can not be null or empty string.");
		}
		
		boolean isUnitExist = false;
		int index = 0;
		for(int l = ConstantUtils.SIZE_UNITS.length; index < l; index++) {
			if(unit.equals(ConstantUtils.SIZE_UNITS[index])) {
				isUnitExist = true;
				break;
			}
		}
		
		if(!isUnitExist) {
			throw new IllegalArgumentException("Parameter \"unit\" value not exist in ConstantUtils.SIZE_UNITS.");
		}
		
		int base = 1024;// may be 1000
		if(index > 0) {
			for(int i = 0; i < index; i++) {
				size = size / base;
			}
		}
		
		return MathUtils.precisionDecimal(size, digit) + unit;
	}
	
	/**
	 * File size unit automatic convert.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param size size to convert, byte
	 * @param digit digit after dot
	 * @return
	 */
	public static String sizeAutoConvert(double size, int digit) {
		int base = 1024;// may be 1000
		int index = (int) Math.floor(Math.log(size) / Math.log(base));
		size = size / Math.pow(base, Math.floor(Math.log(size) / Math.log(base)));
		String unit = ConstantUtils.SIZE_UNITS[index];
		return MathUtils.precisionDecimal(size, digit) + unit;
	}
	
	/**
	 * File size unit automatic convert.
	 * @author Crow
	 * @date 2015年9月18日
	 * @param size
	 * @param digit
	 * @return a HashMap that contains size and unit
	 */
	public static HashMap<String, Object> sizeAutoConvert2Map(double size, int digit) {
		int base = 1024;// may be 1000
		int index = (int) Math.floor(Math.log(size) / Math.log(base));
		size = size / Math.pow(base, Math.floor(Math.log(size) / Math.log(base)));
		String unit = ConstantUtils.SIZE_UNITS[index];
		size = MathUtils.precisionDecimal(size, digit);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("size", size);
		map.put("unit", unit);
		return map;
	}
	
	/**
	 * Open and return a {@link FileInputStream} for the target file.
	 * @author Crow
	 * @date 2015年9月12日
	 * @param file the file to open for input stream
	 * @return
	 * @throws IOException
	 */
	public static FileInputStream getFileInputStream(File file) throws IOException {
		CheckValid.checkFileCanRead(file);
		if(file.isDirectory()){
			throw new IOException("Wrong, the file is a directory.");
		}
		return new FileInputStream(file);
	}
	
	/**
	 * Open and return a {@link BufferedReader} for the target file.
	 * @author Crow
	 * @date 2015年9月12日
	 * @param file the file to open for input stream
	 * @return
	 * @throws IOException
	 */
	public static BufferedReader getBufferedReader(File file) throws IOException {
		return new BufferedReader(new InputStreamReader(getFileInputStream(file), UTF8));
	}
	
	/**
	 * Open and return a {@link FileOutputStream} for the target file.
	 * @author Crow
	 * @date 2015年9月12日
	 * @param file the file to open for output stream
	 * @param append
	 * @return
	 * @throws IOException
	 */
	public static FileOutputStream getFileOutputStream(File file, boolean append) throws IOException {
		// 如果文件存在，判断是否为目录，判断是否可写
		if(file.exists()){
			if(file.isDirectory()){
				throw new IOException("Wrong, the file is a directory.");
			}
			if(!file.canWrite()){
				throw new IOException("Wrong, the file can not be writed.");
			}
		}
		/*
		 * 如果文件不存在，创建父目录，再判断父目录是否存在
		 * 注意：父目录可能已经存在，也可能是一个文件而不是目录，需要对此进行判断
		 */
		else{
			File parentFile = file.getParentFile();
			if(parentFile != null){
				if(!parentFile.mkdirs() && !parentFile.isDirectory()){
					throw new IOException("Wrong, the file's parent directory can not be created.");
				}
			}
		}
		
		return new FileOutputStream(file, append);
	}
	
	/**
	 * Open and return a {@link BufferedWriter} for the target file.
	 * @author Crow
	 * @date 2015年9月12日
	 * @param file the file to open for output stream
	 * @param append
	 * @return
	 * @throws IOException
	 */
	public static BufferedWriter getBufferedWriter(File file, boolean append) throws IOException {
		return new BufferedWriter(new OutputStreamWriter(getFileOutputStream(file, append), UTF8));
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
		return write(file, content, UTF8, true);
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
		return write(file, content, UTF8, append);
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
			closeStreams(bw, osw);
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
			isr = new InputStreamReader(is, UTF8);
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
			closeStream(is);
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
			closeStreams(br, fr);
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
			closeStreams(br, fr);
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
			closeStreams(br, fr);
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
			closeStreams(br, fr);
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
		copy(sourceFile, targetFile, false, false, false);
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
		copy(sourceFile, targetFile, true, false, false);
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
	public static void copy(File sourceFile, File targetFile, boolean overwrite, boolean deleteSourceFile, boolean retainFileDate) throws IOException{
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
				
				copy(tSourceFile, tTargetFile, overwrite, deleteSourceFile, retainFileDate);
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
				closeStreams(fos, fis);
			}
		}
		
		// 判断并设置文件修改时间
		if(retainFileDate) {
			targetFile.setLastModified(sourceFile.lastModified());
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
		copy(sourceFile, targetFile, false, true, false);
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
		copy(sourceFile, targetFile, overwrite, true, false);
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
	
	/**
	 * Compare two files modified date.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param file1
	 * @param file2
	 * @return if 1, then file1 is newer; 
	 * else if -1, then file2 is newer; 
	 * else if 0, then they are the same date.
	 */
	public static int compareFileDate(File file1, File file2) {
		return compareFileDate(file1, file2.lastModified());
	}
	
	/**
	 * Compare two files modified date.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param file1
	 * @param date
	 * @return if 1, then file1 is newer; 
	 * else if -1, then file2 is newer; 
	 * else if 0, then they are the same date.
	 */
	public static int compareFileDate(File file1, Date date) {
		return compareFileDate(file1, date.getTime());
	}
	
	/**
	 * Compare two files modified date.
	 * @author Crow
	 * @date 2015年9月17日
	 * @param file1
	 * @param milliseconds
	 * @return if 1, then file1 is newer; 
	 * else if -1, then file2 is newer; 
	 * else if 0, then they are the same date.
	 */
	public static int compareFileDate(File file1, long milliseconds) {
		if(!CheckValid.checkFileExist(file1)) {
			try {
				throw new FileNotFoundException("File " + file1.getName() + "not found.");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		if(file1.lastModified() > milliseconds) {
			return 1;
		}else if(file1.lastModified() < milliseconds) {
			return -1;
		}
		
		return 0;
	}
	
	
	/**
	 * Compare two files size.
	 * @author Crow
	 * @date 2015年9月20日
	 * @param file1
	 * @param file2
	 * @return
	 * @throws IOException
	 */
	public static int compareFileSize(File file1, File file2) throws IOException {
		long size1 = getSize(file1), size2 = getSize(file2);
		
		if(size1 > size2) {
			return 1;
		} else if (size1 < size2) {
			return -1;
		} else {
			return 0;
		}
	}
}
