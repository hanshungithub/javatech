package cn.hassan.designpattern.command;

import cn.hassan.designpattern.command.impl.GarageDoorOpenCommand;
import cn.hassan.designpattern.command.impl.LightOnCommand;
import cn.hassan.designpattern.command.pojo.GarageDoor;
import cn.hassan.designpattern.command.pojo.Light;
import org.junit.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/20 8:17
 * Description:
 */
public class CommandTest {

	@Test
	public void test() {
		SimpleRemoteControl control = new SimpleRemoteControl();
		Light light = new Light();
		GarageDoor door = new GarageDoor();
		LightOnCommand command = new LightOnCommand(light);
		GarageDoorOpenCommand openCommand = new GarageDoorOpenCommand(door);

		control.setCommand(command);
		control.buttonWasPressed();
		control.setCommand(openCommand);
		control.buttonWasPressed();
	}
}
