package cn.hassan.designpattern.build;

import org.junit.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 7/27/2018 7:42 AM
 * Description:
 */
public class BuilderTest {

	@Test
	public void test() {
		Programmer programmer = new Programmer.ProgrammerBuilder().setFirstName("hassan").setLastName("han").setAddress("hangzhou").build();
		System.out.println(programmer.toString());
	}
}
