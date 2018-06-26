package cn.hassan.thread.concurrent.t0519.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/19 14:51
 * Description:
 */
public interface Hello {

	default void say(){
		System.out.println("hello");
	}

}
