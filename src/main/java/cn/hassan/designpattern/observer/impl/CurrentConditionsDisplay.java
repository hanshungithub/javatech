package cn.hassan.designpattern.observer.impl;

import cn.hassan.designpattern.observer.DisplayElement;
import cn.hassan.designpattern.observer.Observer;
import cn.hassan.designpattern.observer.Subject;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/30 7:39
 * Description:
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {

	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and" + humidity + "% humidity");
	}
}
