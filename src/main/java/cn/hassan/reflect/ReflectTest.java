package cn.hassan.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
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
            Class clazz = Class.forName("cn.hassan.reflect.MacBook");
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
			Class clazz = Class.forName("cn.hassan.reflect.MacBook");
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
}
