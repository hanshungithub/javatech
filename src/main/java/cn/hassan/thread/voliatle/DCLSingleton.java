package cn.hassan.thread.voliatle;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/5 16:55
 * Description:
 */
public class DCLSingleton {

	private volatile static DCLSingleton singleton;

	private DCLSingleton() {
	}

	public static DCLSingleton getInstance() {
		if (singleton == null) {
			synchronized (DCLSingleton.class) {
				singleton = new DCLSingleton();
			}
		}
		return singleton;
	}
}
