package cn.hassan.thread.concurrent.t1;

public class Blogin extends Thread {
	@Override
	public void run() {
		LoginServlet.doPost("b","bb");
	}
}
