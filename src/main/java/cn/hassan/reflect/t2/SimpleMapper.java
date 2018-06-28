package cn.hassan.reflect.t2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/28 10:29
 * Description:
 */
public class SimpleMapper {

	public static <T> String toString(T t) {
		StringBuilder builder = new StringBuilder();
		try {
			Class<?> clazz = t.getClass();
			builder.append(clazz.getName() + "\n");
			Field[] declaredFields = clazz.getDeclaredFields();
			for (Field declaredField: declaredFields) {
				if (!declaredField.isAccessible()) {
					declaredField.setAccessible(true);
				}
				builder.append(declaredField.getName() + "=" + declaredField.get(t) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString();
	}

	public static Object fromString(String str){
		try {
			String[] split = str.split("\n");
			if (split.length < 1) {
				throw new IllegalArgumentException();
			}
			Class<?> clazz = Class.forName(split[0]);
			Object obj = clazz.newInstance();
			for (int i = 1; i < split.length; i++) {
				String[] strs = split[i].split("=");
				if (strs.length < 2) {
					throw new IllegalArgumentException();
				}
				Field field = clazz.getDeclaredField(strs[0]);
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				setFieldValue(field,obj,strs[1]);
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void setFieldValue(Field f, Object obj, String value) throws Exception {
		Class<?> type = f.getType();
		if(type == int.class) {
			f.setInt(obj, Integer.parseInt(value));
		} else if(type == byte.class) {
			f.setByte(obj, Byte.parseByte(value));
		} else if(type == short.class) {
			f.setShort(obj, Short.parseShort(value));
		} else if(type == long.class) {
			f.setLong(obj, Long.parseLong(value));
		} else if(type == float.class) {
			f.setFloat(obj, Float.parseFloat(value));
		} else if(type == double.class) {
			f.setDouble(obj, Double.parseDouble(value));
		} else if(type == char.class) {
			f.setChar(obj, value.charAt(0));
		} else if(type == boolean.class) {
			f.setBoolean(obj, Boolean.parseBoolean(value));
		} else if(type == String.class) {
			f.set(obj, value);
		} else {
			Constructor<?> ctor = type.getConstructor( new Class[] { String.class });
			f.set(obj, ctor.newInstance(value));
		}
	}
}
