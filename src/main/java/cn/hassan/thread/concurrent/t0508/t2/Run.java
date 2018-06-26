package cn.hassan.thread.concurrent.t0508.t2;

import java.util.concurrent.Phaser;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/10 7:29
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(2){
			@Override
			protected boolean onAdvance(int phase, int registeredParties) {
				System.out.println("到达了未通过！ phaser = " + phase + " registeredPartoes = " + registeredParties);
				return super.onAdvance(phase, registeredParties);
			}
		};

	}
}
