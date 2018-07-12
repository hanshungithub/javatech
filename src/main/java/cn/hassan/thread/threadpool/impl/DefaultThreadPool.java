package cn.hassan.thread.threadpool.impl;

import cn.hassan.thread.threadpool.ThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/12 7:22
 * Description:
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
	// 线程池最大限制数
	private static final int MAX_WORKER_NUMBERS = 10;
	// 线程池默认的数量
	private static final int DEFAULE_WORKER_NUMBERS = 5;
	// 线程池最小的数量
	private static final int MIN_WORKER_NUMBERS = 1;
	// 这是一个工作列表，将会向里面插入工作
	private final LinkedList<Job> jobs = new LinkedList<>();
	// 工作者列表
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
	// 工作者线程的数量
	private int workerNum = DEFAULE_WORKER_NUMBERS;

	private AtomicLong threadNum = new AtomicLong();

	public DefaultThreadPool() {
		initializeWokers(DEFAULE_WORKER_NUMBERS);
	}

	public DefaultThreadPool(int num) {
		workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS:num;
		initializeWokers(workerNum);
	}

	@Override
	public void execute(Job job) {
		if (job != null) {
			synchronized (jobs) {
				// 添加一个工作，然后进行通知
				jobs.addLast(job);
				job.notify();
			}
		}
	}

	@Override
	public void shutdown() {
		for (Worker worker: workers) {
			worker.shutdown();
		}
	}

	@Override
	public void addWorkers(int num) {
		synchronized (jobs) {
			// 限制新增的Worker数量不能超过最大值
			if (num + this.workerNum > MAX_WORKER_NUMBERS) {
				num = MAX_WORKER_NUMBERS - this.workerNum;
			}
			initializeWokers(num);
			this.workerNum += num;
		}
	}

	@Override
	public void removeWorker(int num) {
		synchronized (jobs) {
			if (num >= this.workerNum) {
				throw new IllegalArgumentException("beyong workNum");
			}
			int count = 0;
			while (count < num) {
				Worker worker = workers.get(count);
				if (workers.remove(worker)) {
					worker.shutdown();
					count++;
				}
			}
			this.workerNum -= count;
		}
	}

	@Override
	public int getJobSize() {
		return jobs.size();
	}


	private void initializeWokers(int num) {
		for (int i = 0; i < num; i++) {
			Worker worker = new Worker();
			workers.add(worker);
			Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
			thread.start();
		}
	}

	// 工作者，负责消费任务
	class Worker implements Runnable {
		// 是否工作
		private volatile boolean running = true;
		@Override
		public void run() {
			while (running) {
				Job job = null;
				synchronized (jobs){
					while (jobs.isEmpty()) {
						try {
							job.wait();
						} catch (Exception e) {
							// 感知到外部对WorkerThread的中断操作，返回
							Thread.currentThread().interrupt();
							return;
						}
						job = jobs.removeFirst();
					}
					if (job != null) {
						job.run();
					}
				}
			}
		}

		public void shutdown() {
			running = false;
		}
	}
}
