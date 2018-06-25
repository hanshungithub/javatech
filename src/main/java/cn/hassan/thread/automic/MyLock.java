package cn.hassan.thread.automic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/25 20:59
 * Description:
 */
public class MyLock {
    private AtomicInteger status = new AtomicInteger(0);

    /**
     * compareAndSet(expect,update)
     *
     * 如果当前值（status）等于传入的expect，则更新update，否则不更新，更新成功返回true，否则返回false
     */
    public void lock() {
        while (!status.compareAndSet(0, 1)) {
            Thread.yield();
        }
    }

    public void unLock() {
        status.compareAndSet(1, 0);
    }
}
