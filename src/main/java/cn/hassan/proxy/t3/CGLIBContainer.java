package cn.hassan.proxy.t3;

import com.sun.org.apache.xml.internal.security.Init;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.org.glassfish.gmbal.ManagedObjectManagerFactory.getMethod;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 22:08
 * Description:
 */
public class CGLIBContainer {

    //表示每个类的每个切点方法的方法列表
    static Map<Class<?>, Map<InterceptPoint, List<Method>>> interceptMethodsMap = new HashMap<>();


    static Class<?>[] aspects = new Class<?>[] {ServiceLogAspect.class, ExceptionAspect.class };

    /**
     * 分析带@aspect的类
     */
    static {
        Init();
    }

    private static void Init() {
        for (Class<?> cls : aspects){
            Aspect aspect = cls.getAnnotation(Aspect.class);
            if (aspect != null) {
                Method before = getMethod(cls, "before", new Class<?>[]{Object.class, Method.class, Object[].class});
                Method after = getMethod(cls, "after", new Class<?>[]{Object.class, Method.class, Object[].class});
                Method exception = getMethod(cls, "exception", new Class<?>[]{Object.class, Method.class, Object[].class,Throwable.class});
                Class<?>[] value = aspect.value();
                for (Class<?> aClass : value) {

                }
            }
        }
    }

    public static <T> T getInstance(Class clazz) {

        return null;
    }
}
