package cn.hassan.thread.concurrent.t0515.t1;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/15 17:03
 * Description:
 */
public class MyCallBack implements Callable<String> {

	private Integer age;

	public MyCallBack(Integer age) {
		this.age = age;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(8000);
		return "返回的结果是 ---> " + age;
	}


}
