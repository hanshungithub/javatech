package cn.hassan.designpattern.observer;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/30 7:22
 * Description:
 */
public interface Subject {
	void registerObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObserver();
}
