package cn.hassan.thread.reentrantLock.t2;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/11 20:02
 * Description:
 */
public class FinalExample {

    int i;// 普通变量
    final int j;// final变量
    static FinalExample obj;

    public FinalExample () {// 构造函数
        i = 1;// 写普通域
        j = 2;// 写final域
    }

    public static void writer () {// 写线程A执行
        obj = new FinalExample ();
    }

    public static void reader () {// 读线程B执行
        FinalExample object = obj; // 读对象引用
        int a = object.i;// 读普通域
        int b = object.j;// 读final域
    }
}
