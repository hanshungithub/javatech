package cn.hassan.test;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/18 11:16
 * Description:
 */
public class StringTest {

    @Test
    public void testOne() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
        }

        for (Integer integer : list) {
            System.out.println(integer);
            list.add(123);
        }
    }

    @Test
    public void testThree() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hassan");
        System.out.println(map);
    }

    @Test
    public void testTwo() {
        int n = 16;
        System.out.println(tableSizeFor(n));

    }

    int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
}
