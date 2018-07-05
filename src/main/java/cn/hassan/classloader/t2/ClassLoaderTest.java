package cn.hassan.classloader.t2;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/3 22:34
 * Description:
 */
public class ClassLoaderTest {

    @Test
    public void testOne() {
        try {
            MyClassLoader loader = new MyClassLoader();
            Class<?> clazz = loader.findClass("Student");
            String name = clazz.getName();
            System.out.println(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
