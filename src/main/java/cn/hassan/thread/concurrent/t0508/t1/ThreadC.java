package cn.hassan.thread.concurrent.t0508.t1;

import java.util.concurrent.Phaser;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/9 7:24
 * Description:
 */
public class ThreadC extends Thread {

	private Phaser phaser;

	public ThreadC(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {
		PrintTools.methodB();
	}
}
