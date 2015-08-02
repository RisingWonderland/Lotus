/**
 * @author Crow
 * @date 2015年6月19日
 * @version v0.1
 */
package org.rw.crow.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 使用Java提供的GZIP压缩数据和文件，不要压缩过小的内容，否则压缩后内容可能更大。
 * @author Crow
 * @date 2015年6月19日
 * @version v0.1
 *
 */
public class GZipUtils {
	
	private GZipUtils(){}
	
	private static final int BYTE_BUFFER = 1024;
	private static final String GZIP_FILE_SUFFIX = ".gz";
	
	/**
	 * compress data stream
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param is	input stream of bytes
	 * @param os	output stream of bytes
	 * @throws IOException 
	 */
	public static void gzip(InputStream is, OutputStream os) throws IOException{
		GZIPOutputStream gos = new GZIPOutputStream(os);
		
		byte[] data = new byte[BYTE_BUFFER];
		int length = -1;
		while((length = is.read(data)) != -1){
			gos.write(data, 0, length);
		}
		gos.finish();
		gos.flush();
		gos.close();
	}
	
	/**
	 * compress bytes
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param content	the bytes to be compressed
	 * @return
	 * @throws IOException 
	 */
	public static byte[] gzip(byte[] content) throws IOException{
		ByteArrayInputStream bis = new ByteArrayInputStream(content);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		gzip(bis, bos);
		
		bos.flush();
		byte[] result = bos.toByteArray();
		bos.close();
		bis.close();
		
		return result;
	}
	
	/**
	 * compress string, default UTF-8 encoding
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param content	the string to be compressed
	 * @return
	 * @throws IOException
	 */
	public static byte[] gzip(String content) throws IOException{
		return gzip(content, Charset.forName("UTF-8"));
	}
	
	/**
	 * compress string, need to provide encoding
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param content	the string to be compressed
	 * @param cs		encoding
	 * @return
	 * @throws IOException 
	 */
	public static byte[] gzip(String content, Charset cs) throws IOException{
		ByteArrayInputStream bis = new ByteArrayInputStream(content.getBytes(cs));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		gzip(bis, bos);
		
		bos.flush();
		byte[] result = bos.toByteArray();
		bos.close();
		bis.close();
		
		return result;
	}
	
	
	
	
	
	/**
	 * compress file, after generates a .gz file in the same directory, the original file will be deleted 
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param sourceFile	the file to be compressed
	 * @return
	 */
	public static boolean gzip(File sourceFile){
		return gzip(sourceFile, true);
	}
	
	/**
	 * compress file, generates a .gz file in the same directory
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param sourceFile		the file to be compressed
	 * @param deleteSourceFile	if true, the original file will be deleted 
	 * @return
	 */
	public static boolean gzip(File sourceFile, boolean deleteSourceFile){
		File gzipFile = new File(sourceFile.getParent(), sourceFile.getName() + GZIP_FILE_SUFFIX);
		return gzip(sourceFile, gzipFile, deleteSourceFile);
	}
	
	/**
	 * compress file
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param sourceFile		the file to be compressed
	 * @param gzipFile			the generated compressed file
	 * @param deleteSourceFile	if true, the original file will be deleted
	 */
	public static boolean gzip(File sourceFile, File gzipFile, boolean deleteSourceFile){
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(sourceFile));
		} catch (FileNotFoundException e) {
			System.out.println("未能获取要压缩的文件，请确认文件是否存在");
			e.printStackTrace();
			return false;
		}
		
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(gzipFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			try {
				if(bis != null) bis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
		GZIPOutputStream gos = null;
		try {
			gos = new GZIPOutputStream(bos);
			byte[] data = new byte[BYTE_BUFFER];
			int length = -1;
			while((length = bis.read(data)) != -1){
				gos.write(data, 0, length);
			}
			gos.flush();
			gos.finish();
		} catch (IOException e) {
			deleteSourceFile = false;// IOException, undelete file.
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(gos != null) gos.close();
				if(bos != null) bos.close();
				if(bis != null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(deleteSourceFile) return sourceFile.delete();
		
		return true;
	}
	
	
	
	
	/**
	 * uncompress data stream
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param is	input stream of bytes
	 * @param os	output stream of bytes
	 * @throws IOException
	 */
	public static void ungzip(InputStream is, OutputStream os) throws IOException{
		GZIPInputStream gis = new GZIPInputStream(is);
		
		byte[] data = new byte[BYTE_BUFFER];
		int length = -1;
		while((length = gis.read(data)) != -1){
			os.write(data, 0, length);
		}
		
		gis.close();
	}
	
	/**
	 * uncompress bytes
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param content	the bytes to be uncompressed
	 * @return
	 * @throws IOException
	 */
	public static byte[] ungzip(byte[] content) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(content);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		ungzip(bis, bos);
		
		bos.flush();
		byte[] result = bos.toByteArray();
		bos.close();
		bis.close();
		
		return result;
	}
	
	
	
	
	
	/**
	 * gzip解压缩文件，解压缩完成后删除原始文件
	 * 生成的文件名遵循以下规则：
	 * 如果文件以 .gz 为后缀，将此后缀去除；否则在原文件名前加 ungz 前缀。
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param gzipFile	要解压缩的文件
	 * @return
	 */
	public static boolean ungzip(File gzipFile){
		return ungzip(gzipFile, true);
	}
	
	/**
	 * gzip解压缩文件
	 * 生成的文件名遵循以下规则：
	 * 如果文件以 .gz 为后缀，将此后缀去除；否则在原文件名前加 ungz 前缀。
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param gzipFile			要解压缩的文件
	 * @param deleteSourceFile	解压缩完成后是否删除原始文件
	 * @return
	 */
	public static boolean ungzip(File gzipFile, boolean deleteSourceFile){
		String fileName = gzipFile.getName();
		if(fileName.endsWith(GZIP_FILE_SUFFIX)){
			fileName = fileName.substring(0, fileName.lastIndexOf(GZIP_FILE_SUFFIX));
		}else{
			fileName = "ungz-" + fileName;
		}
		File targetFile = new File(gzipFile.getParent(), fileName);
		return ungzip(gzipFile, targetFile, deleteSourceFile);
	}
	
	/**
	 * gzip解压缩文件
	 * @author Crow
	 * @date 2015年6月19日
	 * @version v0.1
	 * @param gzipFile			经gzip压缩后的文件
	 * @param targetFile		gzip解压缩后生成的文件
	 * @param deleteSourceFile	解压缩完成后是否删除原始文件
	 * @return
	 */
	public static boolean ungzip(File gzipFile, File targetFile, boolean deleteSourceFile){
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(gzipFile));
		} catch (FileNotFoundException e) {
			System.out.println("未能获取gz压缩文件，请确认文件是否存在");
			e.printStackTrace();
			return false;
		}
		
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(targetFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			try {
				if(bis != null) bis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
		GZIPInputStream gis = null;
		try {
			gis = new GZIPInputStream(bis);
			byte[] data = new byte[BYTE_BUFFER];
			int length = -1;
			while((length = gis.read(data)) != -1){
				bos.write(data, 0, length);
			}
			bos.flush();
		} catch (IOException e) {
			deleteSourceFile = false;// IOException, undelete file.
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(bos != null) bos.close();
				if(gis != null) gis.close();
				if(bis != null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(deleteSourceFile) return gzipFile.delete();
		
		return true;
	}
}
