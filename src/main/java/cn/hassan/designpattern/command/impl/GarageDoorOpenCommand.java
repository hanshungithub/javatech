package cn.hassan.designpattern.command.impl;

import cn.hassan.designpattern.command.Command;
import cn.hassan.designpattern.command.pojo.GarageDoor;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/21 8:24
 * Description:
 */
public class GarageDoorOpenCommand implements Command {

	GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.ligthOn();
	}
}
