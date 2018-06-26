package cn.hassan.thread.concurrent.t0508.t1;

import java.util.concurrent.Phaser;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/9 7:24
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		PrintTools.phaser = phaser;

		ThreadA threadA = new ThreadA(phaser);
		threadA.setName("A");
		threadA.start();

		ThreadB threadB = new ThreadB(phaser);
		threadB.setName("B");
		threadB.start();

		ThreadC threadC = new ThreadC(phaser);
		threadC.setName("C");
		threadC.start();
	}
}
