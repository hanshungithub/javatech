package cn.hassan.thread.concurrent.t0515.t3;

import java.util.concurrent.RecursiveAction;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/17 8:08
 * Description:
 */
public class MyRecursiveAction extends RecursiveAction {

	private int beginValue;
	private int endValue;

	public MyRecursiveAction(int beginValue, int endValue) {
		this.beginValue = beginValue;
		this.endValue = endValue;
	}

	@Override
	protected void compute() {
		System.out.println(Thread.currentThread().getName() + "-----------");
		if (endValue - beginValue > 2) {
			int middle = (endValue + beginValue) / 2;
			MyRecursiveAction left = new MyRecursiveAction(beginValue, middle);
			MyRecursiveAction right = new MyRecursiveAction(middle + 1, endValue);
			invokeAll(left, right);
		}else {
			System.out.println("打印组合： " + beginValue + "------" + endValue);
			System.out.println("计算结果！");
		}
	}
}
