package cn.hassan.javavm.chaptertwo;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 7/30/2018 9:37 PM
 * Description:
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1M = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1M];

    public static void testGc(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }

    @Test
    public void test() {
        testGc();
    }

}
