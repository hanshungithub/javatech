package cn.hassan.file;

import org.junit.Test;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/25 16:11
 * Description:
 */
public class FileInputStreamTestClass {

    public void readFile(){
        try {
            File file = new File("E:\\project\\ideaproject\\javatech\\src\\main\\resources\\data.txt");
            FileInputStream inputStream = new FileInputStream(file);
            FileOutputStream outputStream = new FileOutputStream(new File("E:\\project\\ideaproject\\javatech\\src\\main\\java\\cn\\hassan\\file\\a.txt"));
            byte[] bytes = new byte[1024];
            //int bytesRead = inputStream.read(bytes);
            //String data = new String(bytes, 0, bytesRead, "UTF-8");
            //System.out.println(data);
            while ((inputStream.read(bytes)) != -1){
                outputStream.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        readFile();
    }
}
