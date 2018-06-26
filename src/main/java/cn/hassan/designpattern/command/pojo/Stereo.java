package cn.hassan.designpattern.command.pojo;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/26 7:29
 * Description:
 */
public class Stereo {

	public void on() {
		System.out.println("stereo is on ...");
	}

	public void off() {
		System.out.println("stereo is off");
	}

	public void setCd() {
		System.out.println("stereo setCd");
	}

	public void setDvd() {
		System.out.println("stereo setDvd");
	}

	public void setRadio() {
		System.out.println("stereo setRadio");
	}

	public void setVolume() {
		System.out.println("stereo setVolume");
	}
}
