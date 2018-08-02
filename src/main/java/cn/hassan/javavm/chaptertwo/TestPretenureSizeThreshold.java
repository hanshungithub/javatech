package cn.hassan.javavm.chaptertwo;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 8/2/2018 10:20 PM
 * Description: -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:PretenureSizeThreshold=3145728
 */
public class TestPretenureSizeThreshold {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1M];
    }
}
