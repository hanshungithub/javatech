package cn.hassan.lambda.t2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/23 11:16
 * Description:
 */
public class LambdaTest {

	@Test
	public void test01() throws Exception {
		/**
		 * lambda 使用步骤
		 *        1，找到对应的函数式接口
		 *        2，编写一个方法，把函数式接口作为参数传入，编写业务逻辑
		 *        3，调用编写的方法，实现具体的处理逻辑
		 */
		String one = processFile(BufferedReader::readLine);
		System.out.println(one);
	}

	/**
	 * Consumer ---> void accept(T t)
	 */
	@Test
	public void test02() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> resule = new ArrayList<>();

		list.forEach((integer -> resule.add(integer)));
	}

	/**
	 *  Function<T, R> --->  R apply(T t)
	 */
	@Test
	public void test03() {
		List<String> list = Arrays.asList("lambdas", "in", "action");
		List<Integer> map = map(list, (String s) -> s.length());
		map.forEach(param -> {
			System.out.println(param);
		});
	}



	public static <T,R> List<R> map(List<T> list, Function<T, R> function) {
		List<R> result = new ArrayList<>();
		list.forEach(param -> {
			result.add(function.apply(param));
		});
		return result;
	}

	public static String processFile(BufferedReaderProcessor processor) throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/data.txt"));
		return processor.process(bufferedReader);
	}
}
