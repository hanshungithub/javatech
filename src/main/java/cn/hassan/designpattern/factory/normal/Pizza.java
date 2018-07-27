package cn.hassan.designpattern.factory.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/5 16:27
 * Description: pizza抽象类
 */
public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	List<String> list = new ArrayList<>();

	void prepare() {
		System.out.println("Preparing ---> " + name);
		System.out.println("Tossing dough ...");
		System.out.println("Adding sauce ...");
		System.out.println("Adding toppings: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("   "+list.get(i));
		}
	}

	void bake() {
		System.out.println("Bake for 25 minutes at 35");
	}

	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public String getName() {
		return name;
	}
}
