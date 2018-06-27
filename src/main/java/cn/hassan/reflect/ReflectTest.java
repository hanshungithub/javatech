package cn.hassan.reflect;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/27 22:24
 * Description:
 */
public class ReflectTest {

    @Test
    public void testOne() {
        try {
            Class clazz = Class.forName("cn.hassan.reflect.MacBook");
            String name = clazz.getName();
            String canonicalName = clazz.getCanonicalName();
            String simpleName = clazz.getSimpleName();
            Package aPackage = clazz.getPackage();
            System.out.println(aPackage);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
