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
		System.out.println(Integer.hashCode(1));
		map.put(1, "hassan");
		map.put(2, "sherry");
		map.put(3, "jack");
		map.get(1);
    }

    @Test
    public void testTwo() {
        int n = 25;
        System.out.println(tableSizeFor(n));

    }

	/**
	 *
	 * @param cap 参数
	 * @return 2的幂数
	 */
	int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    @Test
	public void exceptionTest() {
		try {
			System.out.println("normal...");
		} catch (Exception e) {
			throw e;
		}finally {
			System.out.println("finally...");
		}
	}
}
