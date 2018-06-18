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

}
