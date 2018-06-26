package cn.hassan.thread.concurrent.t0515.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/16 7:36
 * Description:
 */
public class Run {
	public static void main(String[] args) throws Exception {
		MyCallable able = new MyCallable("userOne", 5000);
		MyCallable able1 = new MyCallable("userTwo", 4000);
		MyCallable able3 = new MyCallable("userThree", 3000);
		MyCallable able4 = new MyCallable("userFour", 2000);
		MyCallable able5 = new MyCallable("userFive", 1000);

		List<Callable> list = new ArrayList<>();
		list.add(able);
		list.add(able1);
		list.add(able5);
		list.add(able3);
		list.add(able4);

		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 19, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
		ExecutorCompletionService<Object> completionService = new ExecutorCompletionService<>(executor);

		for (int i = 0; i < 5; i++) {
			completionService.submit(list.get(i));
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("waiting for print " + (i + 1) + "return value");
			System.out.println(completionService.take().get());
		}
	}
}
