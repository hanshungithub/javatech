package cn.hassan.designpattern.command;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/20 8:11
 * Description:
 */
public class SimpleRemoteControl {
	Command slot;

	public SimpleRemoteControl() {
	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}
}
