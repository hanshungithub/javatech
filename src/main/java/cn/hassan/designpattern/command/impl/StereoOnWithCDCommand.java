package cn.hassan.designpattern.command.impl;

import cn.hassan.designpattern.command.Command;
import cn.hassan.designpattern.command.pojo.Stereo;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/26 7:32
 * Description:
 */
public class StereoOnWithCDCommand implements Command {

	private Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume();
	}
}
