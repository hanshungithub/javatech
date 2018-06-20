package cn.hassan.designpattern.command;

import cn.hassan.designpattern.command.impl.LightOnCommand;
import cn.hassan.designpattern.command.pojo.Light;
import org.junit.jupiter.api.Test;

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
		LightOnCommand command = new LightOnCommand(light);

		control.setCommand(command);
		control.buttonWasPressed();
	}
}
