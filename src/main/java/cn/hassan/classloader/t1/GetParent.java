package cn.hassan.classloader.t1;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/3 20:25
 * Description:
 */
public class GetParent {

    public static class Hello {
        static {
            System.out.println("hello");
        }
    }

    @Test
    public void testOne() {
        ClassLoader classLoader = GetParent.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.getClass().getName());
            classLoader = classLoader.getParent();
        }
        System.out.println(String.class.getClassLoader());
    }

    @Test
    public void testTwo() {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            Class<?> clazz = loader.loadClass("java.util.ArrayList");
            System.out.println(clazz.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThree() {
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            String className = GetParent.class.getName() + "$Hello";
            Class<?> aClass = classLoader.loadClass(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
