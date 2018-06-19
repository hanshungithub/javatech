package cn.hassan.designpattern.singleton;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/15 7:24
 * Description:
 */
public class DoubleCheckSingle {
	private volatile static DoubleCheckSingle uniqueInstance;

	private DoubleCheckSingle() {

	}

	public static DoubleCheckSingle getInstance() {
		synchronized (DoubleCheckSingle.class) {
			if (uniqueInstance == null) {
				uniqueInstance = new DoubleCheckSingle();
			}
		}
		return uniqueInstance;
	}
}
