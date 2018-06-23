package cn.hassan.designpattern.command;

import cn.hassan.designpattern.command.impl.NoCommand;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/22 8:16
 * Description:
 */
public class RemoteControl {

	Command[] onCommands;
	Command[] offCommands;

	public RemoteControl() {
		this.onCommands = new Command[7];
		this.offCommands = new Command[7];

		Command noCommand = new NoCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n------Remote Control------\n");
		for (int i = 0; i < 7; i++) {
			builder.append("[slot " + i + "]" + onCommands[i].getClass().getName() + "   " + offCommands[i].getClass().getName() + "\n");
		}
		return builder.toString();
	}
}
