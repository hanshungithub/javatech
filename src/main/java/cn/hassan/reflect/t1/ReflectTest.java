package cn.hassan.reflect.t1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/27 22:24
 * Description:
 */
public class ReflectTest {

    @Test
    public void testName() {
        try {
			/**
			 * 名称信息
			 */
            Class clazz = Class.forName("cn.hassan.reflect.t1.MacBook");
            String name = clazz.getName();
            String canonicalName = clazz.getCanonicalName();
            String simpleName = clazz.getSimpleName();
            Package aPackage = clazz.getPackage();
			System.out.println(name);
			System.out.println(canonicalName);
			System.out.println(simpleName);
            System.out.println(aPackage);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
	public void testFields() {
		/**
		 * 字段信息
		 */
		try {
			Class clazz = Class.forName("cn.hassan.reflect.t1.MacBook");
			Field site = clazz.getField("site");
			Field[] fields = clazz.getFields();

			boolean accessible = site.isAccessible();
			site.setAccessible(true);

			Class<?> type = site.getType();
			System.out.println("type --> " + type);

			Field name = clazz.getDeclaredField("name");
			Field[] declaredFields = clazz.getDeclaredFields();

			boolean accessible1 = name.isAccessible();

			List<String> obj = Arrays.asList("hassan","sherry");
			Class<?> cls = obj.getClass();
			for(Field f : cls.getDeclaredFields()){
				f.setAccessible(true);
				System.out.println(f.getName()+" - "+f.get(obj));
			}
			System.out.println(site);
			System.out.println(fields);
			System.out.println(name);
			System.out.println(declaredFields);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMethod() {
		try {
			Class<?> clazz = Class.forName("cn.hassan.reflect.t1.MacBook");

			//创建对象
			Constructor<?> constructors = clazz.getConstructor();
			Object obj = constructors.newInstance();

			//创建对象
			Object o = clazz.newInstance();
			//需要传的参数是 方法名 方法需要的参数
			Method method = clazz.getMethod("sayString", String.class);
			//调用方法
			method.invoke(o, "world");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
