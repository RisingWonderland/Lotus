package org.rw.crow.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rw.crow.commons.PathUtils;

/**
 * 
 * @author Crow
 * @date 2015年9月2日
 *
 */
public class FileUtilsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIterateDir() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteFileObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteFileObjectBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteFileObjectCharsetBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadEntrieFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testCopy() {
		String licensePath = PathUtils.getFilePath("LICENSE", new File("").getAbsolutePath().toString());
		System.out.println("Path of the target file:" + licensePath);
		
		File license = new File(licensePath);
		if(!license.exists()){
			System.out.println("target file not found");
			return;
		}
		
		try {
			FileInputStream fis = new FileInputStream(license);
			OutputStream os = System.out;
			byte[] buffer = new byte[1024]; 
			int length = 0;
			while((length = fis.read(buffer)) != -1){
				os.write(buffer, 0, length);
			}
			os.flush();
			os.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCopyFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
