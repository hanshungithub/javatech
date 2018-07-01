package cn.hassan.annotation.t2;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 14:55
 * Description:
 */
public class SimpleContainer {

    public static <T> T getInstance(Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(SimpleInject.class)) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                        Class<?> type = field.getType();
                        field.set(t,getInstance(type));
                    }
                }
            }
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
