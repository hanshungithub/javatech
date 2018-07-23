package cn.hassan.file.normal.t2_filebase;

import java.io.File;

/**
 * Created with idea
 * Author: hss
 * Date: 7/24/2018 7:25 AM
 * Description:
 * * File:文件和目录(文件夹)路径名的抽象表示形式
 * * 构造方法：
 * * 		File(String pathname)：根据一个路径得到File对象
 * * 		File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
 * * 		File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
 */
public class FileConstructor {

	public static void main(String[] args) {

		// File(String pathname)：根据一个路径得到File对象
		// 把F:\webupload\images\fiddler 请求.txt封装成一个File对象
		File file = new File("F:\\webupload\\images\\fiddler 请求.txt");

		// File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
		File file2 = new File("F:\\webupload\\images", "a.txt");

		// File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
		File file3 = new File("F:\\webupload\\images");
		File file4 = new File(file3, "fiddler 请求.txt");

		// 以上三种方式其实效果一样
	}
}
