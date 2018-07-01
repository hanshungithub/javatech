package cn.hassan.annotation.t1;

import java.lang.annotation.Annotation;
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

        Class<?> clazz = Class.forName("cn.hassan.annotation.t1.MethodAnnotations");
        Method method = clazz.getMethod("hello",String.class, String.class);
        Annotation[][] annotations = method.getParameterAnnotations();
        String param1 = null;
        String param2 = null;
        for (int i = 0; i < annotations.length; i++) {
            System.out.println("annotation for parpmter" + (i + 1));
            Annotation[] annotation = annotations[i];
            for (Annotation anno : annotation) {
                if (anno instanceof QueryParam) {
                    QueryParam queryParam = (QueryParam) anno;
                    param1 = queryParam.value();
                    System.out.println(queryParam.annotationType().getSimpleName() + " --- " + param1);
                }else {
                    DefaultValue defaultValue = (DefaultValue) anno;
                    param2 = defaultValue.value();
                    System.out.println(defaultValue.annotationType().getSimpleName() + " --- " + param2);
                }
            }

        }
        Object o = clazz.newInstance();
        method.invoke(o, param1, param2);
    }
}
