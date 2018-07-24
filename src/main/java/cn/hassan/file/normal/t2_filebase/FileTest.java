package cn.hassan.file.normal.t2_filebase;

import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with idea
 * Author: hss
 * Date: 7/24/2018 7:40 AM
 * Description:
 */
public class FileTest {

	/*
	 * 重命名功能:public boolean renameTo(File dest)
	 * 		如果路径名相同，就是改名。
	 * 		如果路径名不同，就是改名并剪切。
	 *
	 * 路径以盘符开始：绝对路径	c:\\a.txt
	 * 路径不以盘符开始：相对路径	a.txt
	 */
	@Test
	public void renameToTest() {
		File file = new File("F:\\webupload\\gao.jpg");
		File file1 = new File("F:\\webupload\\images\\高圆圆.jpg");
		file.renameTo(file1);
	}

	/*
	 * 判断功能:
	 * public boolean isDirectory():判断是否是目录
	 * public boolean isFile():判断是否是文件
	 * public boolean exists():判断是否存在
	 * public boolean canRead():判断是否可读
	 * public boolean canWrite():判断是否可写
	 * public boolean isHidden():判断是否隐藏
	 */
	@Test
	public void fileJudgeTest() {
		File file = new File("F:\\webupload\\images\\高圆圆.jpg");
		System.out.println("isDirectory:" + file.isDirectory());// false
		System.out.println("isFile:" + file.isFile());// true
		System.out.println("exists:" + file.exists());// true
		System.out.println("canRead:" + file.canRead());// true
		System.out.println("canWrite:" + file.canWrite());// true
		System.out.println("isHidden:" + file.isHidden());// false
	}

	/*
	 * 获取功能：
	 * public String getAbsolutePath()：获取绝对路径
	 * public String getPath():获取相对路径
	 * public String getName():获取名称
	 * public long length():获取长度。字节数
	 * public long lastModified():获取最后一次的修改时间，毫秒值
	 */
	@Test
	public void acquireTest() {
		File file = new File("F:\\webupload\\images\\高圆圆.jpg");

		System.out.println("getAbsolutePath:" + file.getAbsolutePath());
		System.out.println("getPath:" + file.getPath());
		System.out.println("getName:" + file.getName());
		System.out.println("length:" + file.length());
		System.out.println("lastModified:" + file.lastModified());

		// 1416471971031
		Date d = new Date(1416471971031L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(d);
		System.out.println(s);
	}

	/*
	 * 获取功能：
	 * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
	 * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
	 */
	@Test
	public void acquireFileTest() {
		// public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
		File file = new File("F:\\webupload");
		String[] list = file.list();
		for (String s: list) {
			System.out.println(s);
		}

		System.out.println("------------------------------");
		//public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
		File[] files = file.listFiles();
		for (File file1: files) {
			System.out.println(file1);
		}
	}

	/* 要想实现这个效果，就必须学习一个接口：文件名称过滤器
	 * public String[] list(FilenameFilter filter)
	 * public File[] listFiles(FilenameFilter filter)
	 */
	@Test
	public void fileFilterTest() {
		// 封装e判断目录
		File file = new File("F:\\webupload");

		// 获取该目录下所有文件或者文件夹的String数组
		// public String[] list(FilenameFilter filter)
		String[] strArray = file.list((dir, name) -> {
			// return false;
			// return true;
			// 通过这个测试，我们就知道了，到底把这个文件或者文件夹的名称加不加到数组中，取决于这里的返回值是true还是false
			// 所以，这个的true或者false应该是我们通过某种判断得到的
			// System.out.println(dir + "---" + name);
			// File file = new File(dir, name);
			// // System.out.println(file);
			// boolean flag = file.isFile();
			// boolean flag2 = name.endsWith(".jpg");
			// return flag && flag2;
			return new File(dir, name).isFile() && name.endsWith(".pdf");
		});

		// 遍历
		for (String s : strArray) {
			System.out.println(s);
		}
	}
}
