package cn.hassan.javavm.chapterone;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/10 14:43
 * Description: -Xss2M(创建线程导致内存溢出)
 */
public class JavaVMStackOOM {
    private void doStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> {
                doStop();
            }).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
