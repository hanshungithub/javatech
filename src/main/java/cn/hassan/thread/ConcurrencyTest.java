package cn.hassan.thread;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/10 21:02
 * Description:
 */
public class ConcurrencyTest {

    private static final long count = 100001;

    public static void main(String[] args) throws Exception {
        concurrency();
        serial();
    }

    public static void concurrency() throws Exception {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i--) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("courrency --- >" + time + "ms,b=" + b);
    }

    public static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i--) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial --- >" + time + "ms,b=" + b);
    }
}
