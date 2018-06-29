package cn.hassan.annotation.t1;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/29 22:07
 * Description:
 */
public class MethodAnnotations {

    public void hello(@QueryParam("action") String action,@DefaultValue("sort") String sort) {
        System.out.println(action + "===" + sort);
    }

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("MethodAnnotations");
        Method method = clazz.getMethod("hello",String.class, String.class);
    }
}
