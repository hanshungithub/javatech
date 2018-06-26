package cn.hassan.thread.concurrent.t0427.t2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/27 8:17
 * Description:
 */
public class RunOne {

	private static Timer timer = new Timer(true);

	static public class MyTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("Thread is start running --- > " + new Date());
		}
	}

	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = "2018-04-27 08:26:00";
			Date newDate = date.parse(dateStr);
			timer.schedule(task,newDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
