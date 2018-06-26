package cn.hassan.thread.concurrent.t0502.t1;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/2 7:32
 * Description: 序列化与反序列化的单利
 */
public class MyObject implements Serializable {

	private static class MyObjectHandler{
		private static final MyObject object = new MyObject();
	}

	private MyObject() {

	}

	public static MyObject getInstance() {
		return MyObjectHandler.object;
	}

	protected Object readResovle() throws Exception {
		System.out.println("call readResolve method!");
		return MyObjectHandler.object;
	}
}
