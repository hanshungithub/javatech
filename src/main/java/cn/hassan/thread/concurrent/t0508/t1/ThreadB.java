package cn.hassan.thread.concurrent.t0508.t1;

import java.util.concurrent.Phaser;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/9 7:23
 * Description:
 */
public class ThreadB extends Thread {

	private Phaser phaser;

	public ThreadB(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {
		PrintTools.methodA();
	}
}
