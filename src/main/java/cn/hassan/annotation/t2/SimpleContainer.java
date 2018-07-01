package cn.hassan.annotation.t2;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 14:55
 * Description:
 */
public class SimpleContainer {

    private static Map<Class<?>, Object> map = new HashMap<>();

    public static <T> T getInstance(Class<T> clazz) {

        boolean annotationPresent = clazz.isAnnotationPresent(SimpleSingleton.class);

        if (!annotationPresent) {
            createInstance(clazz);
        }

        Object obj = map.get(clazz);
        if (obj != null) {
            return (T)obj;
        }

        synchronized (clazz){
            obj = map.get(clazz);
            if (obj == null) {
                obj = createInstance(clazz);
                map.put(clazz, obj);
            }
        }
        return (T) obj;
    }

    private static <T> T createInstance(Class<T> clazz) {
        try {
            //创建对象
            T t = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if(field.isAnnotationPresent(SimpleInject.class)){
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    Class<?> type = field.getType();
                    field.set(t,getInstance(type));
                }
            }
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
