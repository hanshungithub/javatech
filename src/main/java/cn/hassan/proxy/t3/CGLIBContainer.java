package cn.hassan.proxy.t3;

import cn.hassan.annotation.t2.SimpleInject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static com.sun.org.glassfish.gmbal.ManagedObjectManagerFactory.getMethod;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 22:08
 * Description:
 */
public class CGLIBContainer {

    //表示每个类的每个切点方法的方法列表
    private static Map<Class<?>, Map<InterceptPoint, List<Method>>> interceptMethodsMap = new HashMap<>();


    private static Class<?>[] aspects = new Class<?>[] {ServiceLogAspect.class, ExceptionAspect.class };

    /**
     * 分析带@aspect的类
     */
    static {
        Init();
    }

	/**
	 * 分析带@Aspect的类，并初始化到interceptMethodsMap
	 */
	private static void Init() {
        for (Class<?> cls : aspects){
            Aspect aspect = cls.getAnnotation(Aspect.class);
            if (aspect != null) {
            	//public static Method getMethod(final Class<?> cls, final String name, final Class... types)
                Method before = getMethod(cls, "before", Object.class, Method.class, Object[].class);
                Method after = getMethod(cls, "after", Object.class, Method.class, Object[].class);
                Method exception = getMethod(cls, "exception", Object.class, Method.class, Object[].class,Throwable.class);
                Class<?>[] value = aspect.value();
                for (Class<?> interceptted : value) {
					addInterceptMethod(interceptted,InterceptPoint.BEFORE, before);
					addInterceptMethod(interceptted, InterceptPoint.AFTER, after);
					addInterceptMethod(interceptted,InterceptPoint.EXCEPTION, exception);
                }
            }
        }
    }

    public static <T> T getInstance(Class clazz) throws Exception {
		try {
			T obj = createInstance(clazz);
			Field[] fields = clazz.getDeclaredFields();
			for (Field field: fields) {
				if (field.isAnnotationPresent(SimpleInject.class)) {
					if (!field.isAccessible()) {
						field.setAccessible(true);
					}
					Class<?> type = field.getType();
					field.set(obj,getInstance(type));
				}
			}
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }

	private static <T> T createInstance(Class cls) throws Exception {
		if (!interceptMethodsMap.containsKey(cls)) {
			return (T) cls.newInstance();
		}
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(cls);
		enhancer.setCallback(new AspectInterceptor());
		return (T) enhancer.create();
	}

	private static void addInterceptMethod(Class<?> cls, InterceptPoint point, Method method) {
		if (method == null) {
			return;
		}
		Map<InterceptPoint, List<Method>> map = interceptMethodsMap.computeIfAbsent(cls, k -> new HashMap<>());
		List<Method> methods = map.computeIfAbsent(point, k -> new ArrayList<>());
		methods.add(method);
	}

	static class AspectInterceptor implements MethodInterceptor {

		@Override
		public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
			//执行before方法
			List<Method> beforeMethods = getInterceptMethods(o.getClass().getSuperclass(), InterceptPoint.BEFORE);
			for (Method m: beforeMethods) {
				m.invoke(null, o, method, objects);
			}
			try {
				//执行原始方法
				Object result = methodProxy.invokeSuper(o, objects);
				//执行after方法
				List<Method> afterMethods = getInterceptMethods(o.getClass().getSuperclass(), InterceptPoint.AFTER);
				for (Method afterMethod: afterMethods) {
					afterMethod.invoke(null, o, method, objects, result);
				}
				return result;
			} catch (Exception e) {
				//执行异常方法
				List<Method> exceptionMethods = getInterceptMethods(o.getClass().getSuperclass(), InterceptPoint.EXCEPTION);
				for (Method exceptionMethod: exceptionMethods) {
					exceptionMethod.invoke(null, o, method, objects, e);
				}
				throw e;
			}
		}
	}

	static List<Method> getInterceptMethods(Class<?> cls, InterceptPoint point) {
		Map<InterceptPoint, List<Method>> map = interceptMethodsMap.get(cls);
		if (map == null) {
			return Collections.emptyList();
		}
		List<Method> methods = map.get(point);
		if (methods == null) {
			return Collections.emptyList();
		}
		return methods;
	}
}
