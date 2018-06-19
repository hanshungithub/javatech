package cn.hassan.designpattern.singleton;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/13 8:25
 * Description:
 */
public class Singleton {
	private static Singleton uniqueSingleton;

	private Singleton() {

	}

	public static synchronized Singleton getInstacne() {
		if (uniqueSingleton == null) {
			uniqueSingleton = new Singleton();
		}
		return uniqueSingleton;
	}
}
