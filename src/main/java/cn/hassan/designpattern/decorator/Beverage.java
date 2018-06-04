package cn.hassan.designpattern.decorator;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/4 7:22
 * Description: 抽象组件
 */
public abstract class Beverage {
	String description = "Unknow beverage";

	public String getDescription() {
		return description;
	}

	abstract double cost();
}
