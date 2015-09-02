package org.rw.crow.commons;

import java.io.File;

/**
 * Provides some methods for file or directory path.
 * @author Crow
 * @date 2015年9月2日
 *
 */
public class PathUtils {
	
	private static final String SEPARATOR = File.separator;
	
	/**
	 * 根据接收到的字符串，拼接出合法的目录路径，
	 * 该路径不处理文件名，参数中不要包含它。
	 * @author Crow
	 * @date 2015年9月2日
	 * @param paths
	 * @return
	 */
	public static String getDirPath(String... paths){
		return getFilePath(null, paths);
	}
	
	/**
	 * 根据接收到的字符串，拼接出合法的文件路径
	 * 
	 * 针对不含文件名称的目录，执行以下操作：
	 * 去除以下非法字符：
	 * 英文引号
	 * 如何判断应该去除哪些中文引号？
	 * 前置正反斜杠
	 * 
	 * 归正以下字符：
	 * 斜杠
	 * 
	 * 加入以下字符：
	 * 后置正反斜杠
	 * 
	 * @author Crow
	 * @date 2015年9月2日
	 * @param fileName file name
	 * @param paths path fragment
	 * @return
	 */
	public static String getFilePath(String fileName, String... paths){
		int length = paths.length;
		if(length == 0){
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		String pathPart = null;
		String separator = "/", rSeparator = "\\\\";
		if(SEPARATOR.equals("\\")){
			separator = "\\\\";
			rSeparator = "/";
		}
		for (int i = 0; i < length; i++) {
			pathPart = paths[i]
					.replaceAll("\"", "")
					.replaceAll(rSeparator, separator);
			pathPart = pathPart.replaceAll(separator + "$", "") + SEPARATOR;
			sb.append(pathPart);
		}
		
		if(fileName != null){
			sb.append(fileName);
		}
		
		return sb.toString();
	}
	
}
