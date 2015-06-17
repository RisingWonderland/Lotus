package org.rw.crow.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
/**
 * 压缩解压缩工具类，需要JDK1.7+
 * @author Crow
 * @date 2014年8月4日
 * @version 1.2
 * @since JDK 1.7
 *
 */
public class ZipUtils {
	
	private static int zipFileCount = 0;
	private static int zipFolderCount = 0;
	
	/**
	 * 压缩文件方法，调用具有五个入参的zipFiles方法，默认生成源目录，压缩完成后不删除原始文件
	 * 需要JDK1.7+
	 * @author Crow
	 * @date 2014年8月4日
	 * @version v0.1
	 * @param zipingFilePath
	 * @param zipFilePath
	 * @param comments
	 * @throws IOException
	 */
	public static void zipFiles(String zipingFilePath, String zipFilePath, String comments) throws IOException{
		zipFiles(zipingFilePath, zipFilePath, comments, true, false);
	}
	/**
	 * 压缩文件方法，使用InputStream和ZipOutputStream
	 * 需要JDK1.7+
	 * @author Crow
	 * @date 2014年8月4日
	 * @version v0.1
	 * @param zipingFilePath要压缩的文件（夹）
	 * @param zipFilePath	生成的压缩文件目标路径
	 * @param comments		压缩文件注释
	 * @param srcDir		是否生成源目录，默认为true。
	 * 						该参数仅对压缩文件夹造成影响：true，压缩文件中创建指定的文件夹；false，直接创建文件夹内的文件
	 * @param deleteSourceFile 压缩完成后是否删除原始文件，默认为false
	 * @throws IOException
	 */
	public static void zipFiles(String zipingFilePath, String zipFilePath, String comments, boolean srcDir, boolean deleteSourceFile) throws IOException{
		zipFileCount = 0;
		zipFolderCount = 0;
		
		zipingFilePath = zipingFilePath.replaceAll("\\\\", "/");
		zipFilePath = zipFilePath.replaceAll("\\\\", "/");
		File zipingFile = new File(zipingFilePath);
		// 如果要压缩的文件对象不存在，抛出文件不存在异常，终止压缩，不生成任何压缩文件
		if(!zipingFile.exists()){
			throw new FileNotFoundException("要压缩的文件必须存在");
		}
		
		// 创建文件校验流
		CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(zipFilePath), new CRC32());
		// 创建压缩流
		ZipOutputStream zos = new ZipOutputStream(cos, Charset.forName("GBK"));// 支持中文
		zos.setComment(comments);// 设置压缩包注释
		zos.setMethod(ZipOutputStream.DEFLATED);// 启用压缩，DEFLATED是默认配置，除此之外还有STORED，不对文件进行压缩，只用于打包归档
		zos.setLevel(Deflater.BEST_COMPRESSION);// 压缩级别为最强压缩，压缩率越强，耗时越多。压缩级别共有0~9十级

		String entryName = "";
		if(srcDir == true){
			entryName = zipingFile.getName();
		}
		System.out.println("entryName: " + entryName);
		
		long time1 = System.currentTimeMillis();
		recursiveZip(zipingFile, zos, entryName);
		long time2 = System.currentTimeMillis();
		
		zos.close();
		// 根据参数deleteSourceFile判断是否删除原始文件
		if(deleteSourceFile == true){
			delete(zipingFile, true);
		}
		System.out.println("压缩完成，共压缩" + zipFileCount + "个文件，包含" + zipFolderCount + "个文件夹，耗时：" + (time2 - time1) + "毫秒");
	}
	/**
	 * 递归压缩文件（夹）
	 * @author Crow
	 * @date 2014年8月4日
	 * @version v0.1
	 * @param zipingFile	要压缩的文件对象
	 * @param zos			压缩输出流
	 * @param entryName		压缩条目名称，如果zipingFile是目录，entryName将用于拼接出该目录下文件对象的entryName
	 * @throws IOException
	 */
	private static void recursiveZip(File zipingFile, ZipOutputStream zos, String entryName) throws IOException{
		if(zipingFile.isDirectory()){// 如果要压缩的文件对象是目录，遍历目录下的文件对象，调用自身，修改1、3两项入参，进行递归
			zipFolderCount++;
			
			if(!"".equals(entryName)){// 如果文件名不是空字符串，确保以“/”做结尾
				entryName = entryName.replaceAll("/$", "") + "/";
			}
			File[] fileList = zipingFile.listFiles();
			for(File file : fileList){
				recursiveZip(file, zos, entryName + file.getName());
			}
		}else{// 如果要压缩的文件对象是文件，使用压缩输出流生成该文件
			if("".equals(entryName)){
				entryName = zipingFile.getName();
			}
			System.out.println("entryName: " + entryName);
			ZipEntry ze = new ZipEntry(entryName);
			zos.putNextEntry(ze);
			InputStream is = new FileInputStream(zipingFile);
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = is.read(buffer)) != -1){
				zos.write(buffer, 0, len);
			}
			is.close();
			
			zipFileCount++;
		}
	}
	
	/**
	 * 压缩文件方法，调用具有五个入参的zipFilesByBuffer方法，默认生成源目录，压缩完成后不删除原始文件
	 * 需要JDK1.7+
	 * @author Crow
	 * @date 2014年8月4日
	 * @version v0.1
	 * @param zipingFilePath
	 * @param zipFilePath
	 * @param comments
	 * @throws IOException
	 */
	public static void zipFilesByByffer(String zipingFilePath, String zipFilePath, String comments) throws IOException{
		zipFilesByBuffer(zipingFilePath, zipFilePath, comments, true, false);
	}
	/**
	 * 压缩文件方法，使用BufferedInputStream和ZipOutputStream
	 * 需要JDK1.7+
	 * @author Crow
	 * @date 2014年8月4日
	 * @version v0.1
	 * @param zipingFilePath
	 * @param zipFilePath
	 * @param comments
	 * @param srcDir
	 * @throws IOException
	 */
	public static void zipFilesByBuffer(String zipingFilePath, String zipFilePath, String comments, boolean srcDir, boolean deleteSourceFile) throws IOException{
		zipFolderCount = 0;
		zipFileCount = 0;
		
		zipingFilePath = zipingFilePath.replaceAll("\\\\", "/");
		zipFilePath = zipFilePath.replaceAll("\\\\", "/");
		File zipingFile = new File(zipingFilePath);
		// 如果要压缩的文件对象不存在，抛出文件不存在异常，终止压缩，不生成任何压缩文件
		if(!zipingFile.exists()){
			throw new FileNotFoundException("要压缩的文件必须存在");
		}

		// 创建文件校验流
		CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(zipFilePath), new CRC32());
		// 创建压缩流
		ZipOutputStream zos = new ZipOutputStream(cos, Charset.forName("GBK"));// 支持中文
		zos.setComment(comments);// 设置压缩包注释
		zos.setMethod(ZipOutputStream.DEFLATED);// 启用压缩，DEFLATED是默认配置，除此之外还有STORED，不对文件进行压缩，只用于打包归档
		zos.setLevel(Deflater.BEST_COMPRESSION);// 压缩级别为最强压缩，压缩率越强，耗时越多。压缩级别共有0~9十级

		String entryName = "";
		if(srcDir == true){
			entryName = zipingFile.getName();
		}
		System.out.println("entryName: " + entryName);
		
		long time1 = System.currentTimeMillis();
		recursiveZipByBuffer(zipingFile, zos, entryName);
		long time2 = System.currentTimeMillis();
		
		zos.close();
		// 根据参数deleteSourceFile判断是否删除原始文件
		if(deleteSourceFile == true){
			delete(zipingFile, true);
		}
		System.out.println("压缩完成，共压缩" + zipFileCount + "个文件，包含" + zipFolderCount + "个文件夹，耗时：" + (time2 - time1) + "毫秒");
	}
	/**
	 * 递归压缩文件（夹）
	 * @author Crow
	 * @date 2014年8月4日
	 * @version v0.1
	 * @param zipingFile	要压缩的文件对象
	 * @param zos			压缩输出流
	 * @param entryName		压缩条目名称，如果zipingFile是目录，entryName将用于拼接出该目录下文件对象的entryName
	 * @throws IOException
	 */
	private static void recursiveZipByBuffer(File zipingFile, ZipOutputStream zos, String entryName) throws IOException{
		if(zipingFile.isDirectory()){// 如果要压缩的文件对象是目录，遍历目录下的文件对象，调用自身，修改1、3两项入参，进行递归
			zipFolderCount++;
			
			if(!"".equals(entryName)){// 如果文件名不是空字符串，确保以“/”做结尾
				entryName = entryName.replaceAll("/$", "") + "/";
			}
			File[] fileList = zipingFile.listFiles();
			for(File file : fileList){
				recursiveZip(file, zos, entryName + file.getName());
			}
		}else{// 如果要压缩的文件对象是文件，使用压缩输出流生成该文件
			if("".equals(entryName)){
				entryName = zipingFile.getName();
			}
			System.out.println("entryName: " + entryName);
			ZipEntry ze = new ZipEntry(entryName);
			zos.putNextEntry(ze);
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(zipingFile));
			byte[] buffer = new byte[1024];
			int readCount = bis.read(buffer);
			while(readCount != -1){
				zos.write(buffer, 0, readCount);
				readCount = bis.read(buffer);
			}
			zos.flush();
			bis.close();
			
			zipFileCount++;
		}
	}
	
	
	
	
	
	/**
	 * 解压缩zip文件方法，只使用ZipFile类进行解压
	 * 需要JDK1.7+
	 * @author Crow
	 * @date 2014年8月4日
	 * @version v0.1
	 * @param zipFilePath		压缩文件地址
	 * @param unzipTargetPath	解压缩目标地址
	 * @param deleteSourceFile 	是否删除原始压缩文件
	 * @throws IOException
	 */
	public static void unzipFiles(String zipFilePath, String unzipTargetPath, boolean deleteSourceFile) throws IOException{
		// 检查、修改接收到的两个参数，并且确保接收到的输出目录以“/”做结尾
		zipFilePath = zipFilePath.replaceAll("\\\\", "/");
		unzipTargetPath = unzipTargetPath.replaceAll("\\\\", "/").replaceAll("/$", "") + "/";
		System.out.print("解压缩至目录：" + unzipTargetPath + "--->...waiting...");
		// 判断压缩文件和输出目录的有效性
		File tzf = new File(zipFilePath);
		if(tzf == null || !tzf.exists() || tzf.isDirectory()){
			throw new FileNotFoundException("必须指定一个压缩文件");
		}else if(!tzf.getName().endsWith(".zip")){
			throw new FileNotFoundException("必须指定一个zip格式的压缩文件");
		}
		tzf = new File(unzipTargetPath);
		if(tzf == null || tzf.isFile()){// 再解压缩的过程中会判断路径是否存在，不要在此判断exist
			throw new FileNotFoundException("必须指定解压缩目录");
		}
		// 设置编码格式，支持中文压缩文件，这个构造方法需要JDK1.7+
		ZipFile zf = new ZipFile(zipFilePath, Charset.forName("GBk"));
		Enumeration em = zf.entries();
		ZipEntry ze = null;
		OutputStream os = null;
		InputStream is = null;
		
		long time1 = System.currentTimeMillis();
		while(em.hasMoreElements()){
			ze = (ZipEntry) em.nextElement();
			String entryName = ze.getName();
			File unzipFile = new File(unzipTargetPath + entryName);
			// 判断解压缩文件的父目录是否存在，如果不存在，创建
			if(!unzipFile.getParentFile().exists()){
				unzipFile.getParentFile().mkdirs();
			}
			os = new FileOutputStream(unzipFile);
			is = zf.getInputStream(ze);
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = is.read(buffer)) != -1){
				os.write(buffer, 0, len);
			}
			is.close();
			os.flush();
			os.close();
		}
		zf.close();
		long time2 = System.currentTimeMillis();
		
		// 判断是否删除原始压缩文件
		if(deleteSourceFile == true){
			File zipFile = new File(zipFilePath);
			if(zipFile.exists() && zipFile.isFile()){
				zipFile.delete();
			}
		}
		
		System.out.println("成功，耗时：" + (time2 - time1));
	}
	/**
	 * 解压缩zip文件方法，使用ZipFile类和ZipInputStream类进行解压，Ant.jar没有提供ZipInputStream方法
	 * 需要JDK1.7+
	 * @author Crow
	 * @date 2014年8月4日
	 * @version v0.1
	 * @param zipFilePath	压缩文件地址
	 * @param unzipPath		解压缩地址
	 * @param deleteSourceFile 	是否删除原始压缩文件
	 * @throws IOException 
	 */
	public static void unzipFilesByStream(String zipFilePath, String unzipTargetPath, boolean deleteSourceFile) throws IOException{
		// 检查、修改接收到的两个参数，并且确保接收到的输出目录以“/”做结尾
		zipFilePath = zipFilePath.replaceAll("\\\\", "/");
		unzipTargetPath = unzipTargetPath.replaceAll("\\\\", "/").replaceAll("/$", "") + "/";
		System.out.print("解压缩至目录：" + unzipTargetPath + "--->...waiting...");
		// 判断压缩文件和输出目录的有效性
		File tzf = new File(zipFilePath);
		if(tzf == null || !tzf.exists() || tzf.isDirectory()){
			throw new FileNotFoundException("必须指定一个压缩文件");
		}else if(!tzf.getName().endsWith(".zip")){
			throw new FileNotFoundException("必须指定一个zip格式的压缩文件");
		}
		tzf = new File(unzipTargetPath);
		if(tzf == null || tzf.isFile()){// 在解压缩的过程中会判断路径是否存在，不要在此判断exist
			throw new FileNotFoundException("必须指定解压缩目录");
		}
		// 设置编码格式，支持中文压缩文件，这个构造方法需要JDK1.7+
		ZipFile zf = new ZipFile(zipFilePath, Charset.forName("GBK"));
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath), Charset.forName("GBK"));
		ZipEntry ze = null;
		OutputStream os = null;
		InputStream is = null;
		
		long time1 = System.currentTimeMillis();
		while((ze = zis.getNextEntry()) != null){
			String entryName = ze.getName();
			File unzipFile = new File(unzipTargetPath + entryName);
			// 判断解压缩文件的父目录是否存在，如果不存在，创建
			if(!unzipFile.getParentFile().exists()){
				unzipFile.getParentFile().mkdirs();
			}
			os = new FileOutputStream(unzipFile);
			is = zf.getInputStream(ze);
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = is.read(buffer)) != -1){
				os.write(buffer, 0, len);
			}
			is.close();
			os.flush();
			os.close();
		}
		zis.close();
		zf.close();
		long time2 = System.currentTimeMillis();
		
		// 判断是否删除原始压缩文件
		if(deleteSourceFile == true){
			File zipFile = new File(zipFilePath);
			if(zipFile.exists() && zipFile.isFile()){
				zipFile.delete();
			}
		}
		
		System.out.println("成功，耗时：" + (time2 - time1));
	}
	/**
	 * 解压缩zip文件方法，只使用ZipFile类进行解压，使用缓冲流操作数据
	 * 需要JDK1.7+
	 * @author Crow
	 * @date 2014年8月4日
	 * @version v0.1
	 * @param zipFilePath		压缩文件地址
	 * @param unzipTargetPath	解压缩目标地址
	 * @param deleteSourceFile 	是否删除原始压缩文件
	 * @throws IOException
	 */
	public static void unzipFilesByBuffer(String zipFilePath, String unzipTargetPath, boolean deleteSourceFile) throws IOException{
		// 检查、修改接收到的两个参数，并且确保接收到的输出目录以“/”做结尾
		zipFilePath = zipFilePath.replaceAll("\\\\", "/");
		unzipTargetPath = unzipTargetPath.replaceAll("\\\\", "/").replaceAll("/$", "") + "/";
		System.out.print("解压缩至目录：" + unzipTargetPath + "--->...waiting...");
		// 判断压缩文件和输出目录的有效性
		File tzf = new File(zipFilePath);
		if(tzf == null || !tzf.exists() || tzf.isDirectory()){
			throw new FileNotFoundException("必须指定一个压缩文件");
		}else if(!tzf.getName().endsWith(".zip")){
			throw new FileNotFoundException("必须指定一个zip格式的压缩文件");
		}
		tzf = new File(unzipTargetPath);
		if(tzf == null || tzf.isFile()){// 再解压缩的过程中会判断路径是否存在，不要在此判断exist
			throw new FileNotFoundException("必须指定解压缩目录");
		}
		// 设置编码格式，支持中文压缩文件，这个构造方法需要JDK1.7+
		ZipFile zf = new ZipFile(zipFilePath, Charset.forName("GBK"));
		Enumeration em = zf.entries();
		ZipEntry ze = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		// 循环输出压缩条目
		long time1 = System.currentTimeMillis();
		while(em.hasMoreElements()){
			ze = (ZipEntry) em.nextElement();
			String entryName = ze.getName();
			// 拼接出输出文件的完整路径
			String outputPath = unzipTargetPath + entryName;
			// 对ZipEntry进行判断，如果是路径，创建路径；如果是文件，输出文件
			if(ze.isDirectory()){
//				System.out.println("创建目录：" + entryName);
				File dirFile = new File(outputPath);
				if(!dirFile.exists()){
					dirFile.mkdirs();
				}
			}else{
//				System.out.println("创建文件：" + entryName);
				// 要创建文件，先要确保存在文件所在目录
				File dirFile = new File(outputPath.substring(0, outputPath.lastIndexOf("/")));
				if(!dirFile.exists()){
					dirFile.mkdirs();
				}
				// 创建输入流和输出流
				bis = new BufferedInputStream(zf.getInputStream(ze));
				bos = new BufferedOutputStream(new FileOutputStream(new File(outputPath)));
				// 常规缓冲文件读取输出方法
				byte[] buffer = new byte[1024];
				int readCount = bis.read(buffer);
				while(readCount != -1){
					bos.write(buffer, 0, readCount);
					readCount = bis.read(buffer);
				}
				bos.flush();
				bos.close();
			}
		}
		zf.close();
		bis.close();
		long time2 = System.currentTimeMillis();
		
		// 判断是否删除原始压缩文件
		if(deleteSourceFile == true){
			File zipFile = new File(zipFilePath);
			if(zipFile.exists() && zipFile.isFile()){
				zipFile.delete();
			}
		}
		
		System.out.println("成功，耗时：" + (time2 - time1));
	}
	
	
	

	/**
	 * Delete file. (Copy from FileUtils in Project Lotus.)
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
