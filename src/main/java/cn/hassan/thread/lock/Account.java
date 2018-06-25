package cn.hassan.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/25 21:47
 * Description:
 */
public class Account {

    private Lock lock = new ReentrantLock();

    private volatile double money;

    public Account(double money) {
        this.money = money;
    }

    //加钱
    public void add(double money) {
        lock.lock();
        try {
            this.money += money;
        }finally {
            lock.unlock();
        }
    }

    //减钱
    public void reduce(double money) {
        lock.lock();
        try {
            this.money -= money;
        }finally {
            lock.unlock();
        }
    }

    public double getMoney() {
        return money;
    }

    public void lock() {
        lock.lock();
    }

    public void unLock() {
        lock.unlock();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }
}
