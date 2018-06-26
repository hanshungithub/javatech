package cn.hassan.thread.concurrent.t0416.t1;

import java.util.ArrayList;

public class Mylist {
	private static ArrayList<Object> list = new ArrayList();

	public static void add() {
		list.add("hassan");
	}

	public static int size() {
		return list.size();
	}
}
