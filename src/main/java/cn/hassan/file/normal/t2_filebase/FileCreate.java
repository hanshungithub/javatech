package cn.hassan.file.normal.t2_filebase;

import java.io.File;
import java.io.IOException;

/**
 * Created with idea
 * Author: hss
 * Date: 7/24/2018 7:31 AM
 * Description:
 *  创建功能：
 *  public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
 *  public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
 *  public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
 */
public class FileCreate {

	public static void main(String[] args) {
		// 需求：我要在e盘目录下创建一个文件夹files
		File file = new File("F:\\webupload\\files");
		System.out.println("mkdir: ->" + file.mkdir());

		// 需求:我要在e盘目录files下创建一个文件a.txt
		File file1 = new File("F:\\webupload\\files\\a.txt");
		try {
			System.out.println("createNewFile: ->" + file1.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
