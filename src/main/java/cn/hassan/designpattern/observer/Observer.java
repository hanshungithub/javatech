package cn.hassan.designpattern.observer;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/30 7:23
 * Description:
 */
public interface Observer {
	void update(float temp, float humidity, float pressure);
}
