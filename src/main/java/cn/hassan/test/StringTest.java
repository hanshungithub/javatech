package cn.hassan.test;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
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
        ArrayList<Integer> list = new ArrayList<>();
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

    /********************************linkedHashMap***********************************/

    @Test
    public void linkedHashMapOne() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(10, 0.75f, true);

        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.get("2");//2移动到了内部的链表末尾
        map.get("4");//4调整至末尾
        map.put("3", "e");//3调整至末尾
        map.put(null, null);//插入两个新的节点 null
        map.put("5", null);//5
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
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

	@Test
    public void testLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("hassan");
        list.add("sherru");
    }

    /*****************************************************TreeMap**************************************************/

    @Test
    public void testTreeMap() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "hassan");
        map.put(2, "sherry");
        map.put(3, "jack");
    }

    @Test
	public void testCalander() {
		getPastDate(7);
	}
	/**
	 * 获取过去第几天的日期
	 *
	 * @param past
	 * @return
	 */
	public static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = format.format(today);
		System.out.println(result);
		return result;
	}
}
