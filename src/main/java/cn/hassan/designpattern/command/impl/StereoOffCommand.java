package cn.hassan.designpattern.command.impl;

import cn.hassan.designpattern.command.Command;
import cn.hassan.designpattern.command.pojo.Stereo;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/26 7:37
 * Description:
 */
public class StereoOffCommand implements Command {

	private Stereo stereo;

	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.off();
	}
}
