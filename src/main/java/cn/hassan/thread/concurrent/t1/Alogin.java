package cn.hassan.thread.concurrent.t1;

public class Alogin extends Thread {
	@Override
	public void run() {
		LoginServlet.doPost("a", "aa");
	}
}
