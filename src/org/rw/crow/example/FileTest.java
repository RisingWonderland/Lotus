package org.rw.crow.example;

import java.io.File;

import org.rw.crow.io.FileUtils;

/**
 * Test FileUtils
 * @author Crow
 * @date 2015年5月11日
 * @version v0.1
 */
public class FileTest {

	public static void main(String[] args) {
//		FileUtils.iterateDir(new File("G:\\TFS Basic User Guide"));
//		File logFile = new File("E:\\logForLotus.txt");
//		FileUtils.write(logFile, System.currentTimeMillis(), true);
		
		File fileShouldBeRead = new File("G:\\TempFiles\\小知识.txt");
		String data = FileUtils.readEntrieFile(fileShouldBeRead);
		System.out.println(data);
	}
	
}
