package cn.hassan.classloader.t2;

import cn.hassan.file.BinaryFileUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/3 22:10
 * Description:
 */
public class MyClassLoader extends ClassLoader {

    private static String BASE_DIR = "E:\\project\\test\\";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name.replaceAll("\\.", "/");
        fileName = BASE_DIR + fileName + ".class";
        try {
            byte[] bytes = BinaryFileUtils.readFileToByteArray(fileName);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException ex) {
            throw new ClassNotFoundException("failed to load class " + name, ex);
        }
    }
}
