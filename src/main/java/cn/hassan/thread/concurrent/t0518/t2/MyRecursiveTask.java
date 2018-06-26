package cn.hassan.thread.concurrent.t0518.t2;

import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/18 8:14
 * Description:
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {

	private int beginValue;
	private int endValue;

	public MyRecursiveTask(int beginValue, int endValue) {
		this.beginValue = beginValue;
		this.endValue = endValue;
		System.out.println("#" + (beginValue + " " +endValue));
	}

	@Override
	protected Integer compute() {
		System.out.println(Thread.currentThread().getName() + "----------------------");
		Integer sum = 0;
		System.out.println("compute=" + beginValue + " " + endValue);
		if (endValue - beginValue != 0) {
			System.out.println("!=0");
			int middle = (endValue + beginValue) / 2;
			System.out.println("left 传入的值：" + beginValue + " " + middle);
			MyRecursiveTask left = new MyRecursiveTask(beginValue, middle);
			System.out.println("right 传入的值：" + (middle + 1) + " " + endValue);
			MyRecursiveTask reght = new MyRecursiveTask(middle + 1, endValue);
			invokeAll(left, reght);
			return left.join() + reght.join();
		}else {
			return endValue;
		}
	}
}
