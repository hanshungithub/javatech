package cn.hassan.reflect.t3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/28 18:47
 * Description:
 */
public class PersonTest {

	@Test
	public void testOne() throws Exception {
		// 获取字节码文件对象
		Class c = Class.forName("cn.itcast_01.Person");

		// 获取构造方法
		// public Constructor[] getConstructors():所有公共构造方法
		// public Constructor[] getDeclaredConstructors():所有构造方法
		// Constructor[] cons = c.getDeclaredConstructors();
		// for (Constructor con : cons) {
		// System.out.println(con);
		// }

		// 获取单个构造方法
		// public Constructor<T> getConstructor(Class<?>... parameterTypes)
		// 参数表示的是：你要获取的构造方法的构造参数个数及数据类型的class字节码文件对象
		Constructor con = c.getConstructor();// 返回的是构造方法对象

		// Person p = new Person();
		// System.out.println(p);
		// public T newInstance(Object... initargs)
		// 使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
		Object obj = con.newInstance();
		System.out.println(obj);

		// Person p = (Person)obj;
		// p.show();
	}

	@Test
	public void testTwo() throws Exception {
		Class<?> clazz = Class.forName("cn.hassan.reflect.t3.Person");
		//Constructor<?> constructor = clazz.getConstructor(new Class[]{String.class, int.class, String.class});
		Constructor<?> constructor = clazz.getConstructor(String.class, int.class, String.class);
		Object o = constructor.newInstance("hassan", 25, "杭州");
		//System.out.println(o);
		Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class);
		declaredConstructor.setAccessible(true);
		Object hassan = declaredConstructor.newInstance("hassan");
		System.out.println(hassan);

		boolean accessible = constructor.isAccessible();
		boolean accessible1 = declaredConstructor.isAccessible();
		System.out.println(accessible +" --- "+ accessible1);
	}

	@Test
	public void testThree() throws Exception{
		Class<?> clazz = Class.forName("cn.hassan.reflect.t3.Person");

		Constructor<?> constructor = clazz.getConstructor();
		//创建对象
		Object o = constructor.newInstance();

		// 获取所有的成员变量(私有的和默认的需要使用getDeclaredField来获取)
		// Field[] fields = c.getFields();
		// Field[] fields = c.getDeclaredFields();
		// for (Field field : fields) {
		// System.out.println(field);
		// }

		Field address = clazz.getField("address");
		address.set(o, "hangzhou");
		System.out.println(o);

		//私有字段必须使用getDeclaredField来获取
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true);
		name.set(o, "hassan");
		System.out.println(o);

		Field age = clazz.getDeclaredField("age");
		age.setAccessible(true);
		age.set(o, 25);
		System.out.println(o);
	}
}
