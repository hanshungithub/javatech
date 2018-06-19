package cn.hassan.designpattern.singleton;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/13 8:37
 * Description:
 */
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;

	private static ChocolateBoiler chocolateBoiler;

	private ChocolateBoiler getInstance() {
		if (chocolateBoiler == null) {
			return new ChocolateBoiler();
		}
		return chocolateBoiler;
	}

	private ChocolateBoiler() {

	}

	private ChocolateBoiler(boolean empty, boolean boiled) {
		this.empty = empty;
		this.boiled = boiled;
	}

	public void fill() {
		if(isEmpty()){
			empty = false;
			boiled = false;
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}
}
