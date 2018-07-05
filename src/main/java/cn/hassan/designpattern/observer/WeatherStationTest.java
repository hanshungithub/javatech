package cn.hassan.designpattern.observer;

import cn.hassan.designpattern.observer.impl.CurrentConditionsDisplay;
import cn.hassan.designpattern.observer.impl.WeatherData;
import org.junit.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/30 8:01
 * Description:
 */
public class WeatherStationTest {

	@Test
	public void test01() {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(80,65,30.4f);
	}
}
