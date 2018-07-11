package cn.hassan.thread.voliatle.t1;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/11 17:17
 * Description:
 */
public class VolatileFeaturesExample {

    volatile long vl = 0L; // 使用volatile声明64位的long型变量

    public void set(long l) {
        vl = l; // 单个volatile变量的写
    }

    public void getAndIncrement () {
        vl++; // 复合（多个）volatile变量的读/写
    }

    public long get() {
        return vl; // 单个volatile变量的读
    }
}
