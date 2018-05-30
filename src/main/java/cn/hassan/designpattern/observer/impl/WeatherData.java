package cn.hassan.designpattern.observer.impl;

import cn.hassan.designpattern.observer.Observer;
import cn.hassan.designpattern.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/30 7:30
 * Description:
 */
public class WeatherData implements Subject {

	private List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if (i > 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(temperature,humidity,pressure);
		}
	}

	public void measurementsChanged() {
		notifyObserver();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
