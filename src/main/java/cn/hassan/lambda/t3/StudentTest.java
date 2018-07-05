package cn.hassan.lambda.t3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/4 8:18
 * Description:
 */
public class StudentTest {
	List<Student> students = Arrays.asList(new Student("zhangsan", 89d), new Student("lisi", 89d),
			new Student("wangwu", 98d));

	@Test
	public void testOne() {
		List<Student> filter = filter(students, t -> t.getScore() > 80);
		for (Student student: filter) {
			System.out.println(student);
		}
	}


	@Test
	public void testTwo() {
		List<String> map = map(students, Student::getName);
		System.out.println(map);

		List<String> map1 = map(students, t -> t.getName().toUpperCase());
		System.out.println(map1);
	}

	@Test
	public void testThree() {
		consumer(students, t -> t.setName(t.getName().toUpperCase()));
		System.out.println(students);
	}

	/**
	 * boolean test(T t)函数接口
	 * @param list 参数列表
	 * @param predicate 传入的代码
	 * @param <E> 类型参数
	 * @return 返回符合结果的值
	 */
	private static <E> List<E> filter(List<E> list, Predicate<E> predicate) {
		List<E> result = new ArrayList<>();
		for (E e: list) {
			if (predicate.test(e)) {
				result.add(e);
			}
		}
		return result;
	}

	/**
	 * R apply(T t)函数接口
	 * @param list 参数列表
	 * @param mapper 传入的代码
	 * @param <T> 类型参数
	 * @param <R> 类型参数
	 * @return 返回符合的值
	 */
	private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
		List<R> result = new ArrayList<>();
		for (T t: list) {
			result.add(mapper.apply(t));
		}
		return result;
	}


	/**
	 * void accept(T t)
	 * @param list 参数列表
	 * @param consumer 传入的代码
	 * @param <E> 类型参数
	 */
	private static <E> void consumer(List<E> list, Consumer<E> consumer) {
		for (E e: list) {
			consumer.accept(e);
		}
	}
}
