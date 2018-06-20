package cn.hassan.designpattern.command.impl;

import cn.hassan.designpattern.command.Command;
import cn.hassan.designpattern.command.pojo.Light;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/20 8:05
 * Description:
 */
public class LightOnCommand implements Command {

	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}
}
