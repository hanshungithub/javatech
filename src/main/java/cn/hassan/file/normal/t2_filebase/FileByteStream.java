package cn.hassan.file.normal.t2_filebase;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with idea
 * Author: hss
 * Date: 7/24/2018 10:25 AM
 * Description:
 * IO流的分类：
 * 		流向：
 * 			输入流	读取数据
 * 			输出流 写出数据
 * 		数据类型：
 * 			字节流
 * 				字节输入流	读取数据	InputStream
 * 				字节输出流	写出数据	OutputStream
 * 			字符流
 * 				字符输入流	读取数据	Reader
 * 				字符输出流	写出数据	Writer
 * 注意：一般我们在探讨IO流的时候，如果没有明确说明按哪种分类来说，默认情况下是按照数据类型来分的。
 */
public class FileByteStream {

	/*
	 * FileOutputStream(File file)
	 * FileOutputStream(String name)
	 */
	@Test
	public void fileOutPutStreamOne() throws IOException {
		// 创建字节输出流对象
		// FileOutputStream(File file)
		// File file = new File("fos.txt");
		// FileOutputStream fos = new FileOutputStream(file);
		// FileOutputStream(String name)
		FileOutputStream fos = new FileOutputStream("fos.txt",true);
		/*
		 * 创建字节输出流对象了做了几件事情：
		 * A:调用系统功能去创建文件
		 * B:创建fos对象
		 * C:把fos对象指向这个文件
		 */

		//写数据
		fos.write("hello,IO ".getBytes());
		fos.write("java".getBytes());

		//释放资源
		//关闭此文件输出流并释放与此流有关的所有系统资源。
		fos.close();
		/*
		 * 为什么一定要close()呢?
		 * A:让流对象变成垃圾，这样就可以被垃圾回收器回收了
		 * B:通知系统去释放跟该文件相关的资源
		 */
		//java.io.IOException: Stream Closed
		//fos.write("java".getBytes());
	}

	/*
	 * 字节输入流操作步骤：
	 * A:创建字节输入流对象
	 * B:调用read()方法读取数据，并把数据显示在控制台
	 * C:释放资源
	 *
	 * 读取数据的方式：
	 * A:int read():一次读取一个字节
	 * B:int read(byte[] b):一次读取一个字节数组
	 */
	@Test
	public void fileInputStreamOne() throws IOException{
		// FileInputStream(String name)
		// FileInputStream fis = new FileInputStream("fis.txt");
		FileInputStream fis = new FileInputStream("fos.txt");

		// // 调用read()方法读取数据，并把数据显示在控制台
		// // 第一次读取
		// int by = fis.read();
		// System.out.println(by);
		// System.out.println((char) by);
		//
		// // 第二次读取
		// by = fis.read();
		// System.out.println(by);
		// System.out.println((char) by);
		//
		// // 第三次读取
		// by = fis.read();
		// System.out.println(by);
		// System.out.println((char) by);
		// // 我们发现代码的重复度很高，所以我们要用循环改进
		// // 而用循环，最麻烦的事情是如何控制循环判断条件呢?
		// // 第四次读取
		// by = fis.read();
		// System.out.println(by);
		// // 第五次读取
		// by = fis.read();
		// System.out.println(by);
		// //通过测试，我们知道如果你读取的数据是-1，就说明已经读取到文件的末尾了

		// 用循环改进
		// int by = fis.read();
		// while (by != -1) {
		// System.out.print((char) by);
		// by = fis.read();
		// }

		// 最终版代码
		int by = 0;
		// 读取，赋值，判断
		while ((by = fis.read()) != -1) {
			System.out.print((char) by);
		}

		// 释放资源
		fis.close();
	}
	/*
	 * 一次读取一个字节数组：int read(byte[] b)
	 * 返回值其实是实际读取的字节个数。
	 */
	@Test
	public void fileInputStreamTwo() throws IOException{
		// 创建字节输入流对象
		// FileInputStream fis = new FileInputStream("fis2.txt");
		FileInputStream fis = new FileInputStream("test.txt");

		// 读取数据
		// 定义一个字节数组
		// 第一次读取
		// byte[] bys = new byte[5];
		// int len = fis.read(bys);
		// // System.out.println(len);
		// // System.out.println(new String(bys));
		// // System.out.println(new String(bys, 0, len));
		// System.out.print(new String(bys, 0, len));
		//
		// // 第二次读取
		// len = fis.read(bys);
		// // System.out.println(len);
		// // System.out.println(new String(bys));
		// // System.out.println(new String(bys, 0, len));
		// System.out.print(new String(bys, 0, len));
		//
		// // 第三次读取
		// len = fis.read(bys);
		// // System.out.println(len);
		// // System.out.println(new String(bys));
		// // System.out.println(new String(bys, 0, len));
		// System.out.print(new String(bys, 0, len));
		//
		// // 第四次读取
		// len = fis.read(bys);
		// // System.out.println(len);
		// // System.out.println(new String(bys, 0, len));
		// System.out.print(new String(bys, 0, len));
		// // 代码重复了，用循环改进
		// // 但是，我不知道结束条件
		// // len = fis.read(bys);
		// // System.out.println(len);
		// // len = fis.read(bys);
		// // System.out.println(len);
		// // 如果读取到的实际长度是-1，就说明没有数据了

		// byte[] bys = new byte[115]; // 0
		// int len = 0;
		// while ((len = fis.read(bys)) != -1) {
		// System.out.print(new String(bys, 0, len));
		// // System.out.print(new String(bys)); //千万要带上len的使用
		// }

		// 最终版代码
		// 数组的长度一般是1024或者1024的整数倍
		byte[] bys = new byte[1024];
		int len;
		while ((len = fis.read(bys)) != -1) {
			System.out.print(new String(bys, 0, len));
		}

		// 释放资源
		fis.close();
	}

	@Test
	public void copyFileTestOne() throws Exception{
		//数据源
		FileInputStream fis = new FileInputStream("test.txt");
		//目的地
		FileOutputStream fos = new FileOutputStream("b.txt");
		byte[] bytes = new byte[1024];
		int len;
		while ((len = fis.read(bytes)) != -1){
			fos.write(bytes, 0, len);
		}
		fis.close();
		fos.close();
	}
}
