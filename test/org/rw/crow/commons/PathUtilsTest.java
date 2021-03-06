package org.rw.crow.commons;

import static org.junit.Assert.fail;

import java.io.File;

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
public class PathUtilsTest {

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
	public void testUnifySeparator(){
		String path1 = "C:\\\"Workspaces\"\\MyEclipse Professional 2014\\Lotus";
//		String path2 = "C:/Workspaces/MyEclipse Professional 2014/Lotus";
		System.out.println(PathUtils.unifySeparator(path1));
//		System.out.println(PathUtils.unifySeparator(path2, PathUtils.BACKSLASH));
	}
	
	@Test
	public void testPathNotEndWithSlash(){
		String path1 = "C:/Workspaces/MyEclipse Professional 2014/Lotus/";
		System.out.println(PathUtils.pathNotEndWithSlash(path1));
	}
	
	@Test
	public void testPathEndWithSlash(){
		String path1 = "C:/Workspaces/MyEclipse Professional 2014/Lotus";
		String path2 = "C:/Workspaces/MyEclipse Professional 2014/Lotus/";
		String path3 = "C:/Workspaces/MyEclipse Professional 2014/Lotus/README.md";
		System.out.println(PathUtils.pathEndWithSlash(path1));
		System.out.println(PathUtils.pathEndWithSlash(path2));
		System.out.println(PathUtils.pathEndWithSlash(path3));
	}
	
	@Test
	public void testGetFileName(){
		String path = "C:/Workspaces/MyEclipse Professional 2014/Lotus/README.md";
		File file = new File(path);
		String fileName = file.getName();
		System.out.println(fileName);
	}
	
	@Test
	public void testGetDirPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFilePath() {
		String path = PathUtils.getFilePath("README.md", 
			"C:\\\"Workspaces\"\\MyEclipse Professional 2014\\Lotus", 
			"alice/kepler/", 
			"galileo");
		System.out.println(path);
	}
	
	@Test
	public void testRemoveFileNameSuffixes(){
		System.out.println(PathUtils.removeFileNameSuffixes("README.md"));
	}
	
	@Test
	public void testGetPlainFileName(){
		String path1 = "C:/Workspaces/MyEclipse Professional 2014/Lotus/";
		String path2 = "C:/Workspaces/MyEclipse Professional 2014/Lotus/README.md";
		System.out.println(PathUtils.getPlainFileName(path1));
		System.out.println(PathUtils.getPlainFileName(path2));
	}

}
