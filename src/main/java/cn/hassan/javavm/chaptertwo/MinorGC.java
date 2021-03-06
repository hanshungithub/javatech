package cn.hassan.javavm.chaptertwo;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/14 22:04
 * Description: -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 */
public class MinorGC {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        testAllocation();
    }

    public static void testAllocation() {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2*_1M];
        allocation2 = new byte[2*_1M];
        allocation3 = new byte[2*_1M];
        allocation4 = new byte[4*_1M];
    }
}
