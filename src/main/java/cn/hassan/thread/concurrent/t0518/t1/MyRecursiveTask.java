package cn.hassan.thread.concurrent.t0518.t1;


import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/18 7:33
 * Description:
 */
public class MyRecursiveTask extends RecursiveTask<String> {

	private int beginValue;
	private int endValue;

	public MyRecursiveTask(int beginValue, int endValue) {
		this.beginValue = beginValue;
		this.endValue = endValue;
	}

	@Override
	protected String compute() {
		if (endValue - beginValue > 2) {
			int middle = (endValue + beginValue) / 2;
			MyRecursiveTask taskOne = new MyRecursiveTask(beginValue, middle);
			MyRecursiveTask taskTwo = new MyRecursiveTask(middle + 1, endValue);
			invokeAll(taskOne, taskTwo);
			return taskOne.join() + taskTwo.join();
		}else {
			StringBuilder result = new StringBuilder();
			for (int i = beginValue; i <= endValue ; i++) {
				result.append(i);
			}
			System.out.println("else 返回值 ：" + result +"---"+ "(" + beginValue + "," + endValue + ")");
			return result.toString();
		}
	}
}
