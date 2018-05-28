package cn.hassan.stream.t1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/23 17:21
 * Description:
 */
public class StreamTest1 {
	List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH) );

	private static void accept(String[] item) {
		System.out.println(item.toString());
	}

	/**
	 * 使用流的步骤：
	 *     1，一个数据源
	 *     2，一个中间操作链
	 *     3，一个终端操作
	 */
	@Test
	public void test01() {
		List<String> collect = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());
		collect.forEach(System.out::println);
	}

	@Test
	public void test02() {
		List<String> collect = menu.stream().filter(d -> {
			System.out.println("filtering ---> " + d.getName());
			return d.getCalories() > 300;
		}).map(d -> {
			System.out.println("mapping --->" + d.getName());
			return d.getName();
		}).limit(3).collect(Collectors.toList());
		collect.forEach(System.out::println);
	}

	@Test
	public void test03() {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(integer -> integer % 2 == 0).distinct().forEach(System.out::println);
	}

	@Test
	public void test04() {

		String[] str = new String[]{"Hello", "World"};
		List<String[]> collect = Arrays.stream(str).map(word -> word.split("")).collect(Collectors.toList());
		collect.forEach(item -> {
			System.out.println(item.length);
		});
	}

	@Test
	public void test05() {
		menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish -> {
			System.out.println(dish.getName());
		});
	}
}
