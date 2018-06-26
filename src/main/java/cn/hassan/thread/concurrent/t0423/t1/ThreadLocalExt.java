package cn.hassan.thread.concurrent.t0423.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/23 7:22
 * Description:
 */
public class ThreadLocalExt extends ThreadLocal {

	/**
	 * 设置初始化值 如果不设置则默认返回的是nul
	 * @return default value
	 */
	@Override
	protected Object initialValue() {
		return "defaule value";
	}

}
