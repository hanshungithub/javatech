package cn.hassan.designpattern.command;

import cn.hassan.designpattern.command.impl.StereoOffCommand;
import cn.hassan.designpattern.command.impl.StereoOnWithCDCommand;
import cn.hassan.designpattern.command.pojo.Stereo;
import org.junit.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/26 7:38
 * Description:
 */
public class RemoteLoader {

	@Test
	public void testStereo() {
		RemoteControl control = new RemoteControl();

		Stereo stereo = new Stereo();

		StereoOnWithCDCommand onWithCDCommand = new StereoOnWithCDCommand(stereo);
		StereoOffCommand offCommand = new StereoOffCommand(stereo);

		control.setCommand(0,onWithCDCommand,offCommand);
		control.onButtonWasPushed(0);
		control.offButtonWasPushed(0);
	}
}
