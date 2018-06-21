package cn.hassan.designpattern.command.pojo;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/21 8:21
 * Description:
 */
public class GarageDoor {

	public void up() {
		System.out.println("garage door up");
	}

	public void down() {
		System.out.println("garage door down");
	}

	public void stop() {
		System.out.println("garage door stop");
	}

	public void ligthOn() {
		System.out.println("garage lightOn");
	}

	public void lightOff() {
		System.out.println("garage lightOff");
	}
}
