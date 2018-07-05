package cn.hassan.generic;

import org.junit.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/23 17:01
 * Description:
 */
public class Genetric {

	public static <T> T indexOf(T[] arr, T ele) {
		for (T t : arr) {
			if (t.equals(ele)) {
				return t;
			}
		}
		return null;
	}

	@Test
	public void testOne() {
		Integer[] num = new Integer[]{1, 2, 3, 4, 5, 6};
		Integer integer = indexOf(num, 3);
		System.out.println(integer);
	}

    /**
     * public <T extends E> void addAll(DynamicArray<T> c)
     *
     * T extends E E是DynamicArray的类型限定 T是addAll的类型限定
     * DynamicArray<Number> number = new DynamicArray<>();的类型限定是Number
     * DynamicArray<Integer> inte = new DynamicArray<>();的类型限定是Integer
     * inte里添加参数，number调用addAll()方法 number是Number类型的 inte是Integer类型的
     *
     * Integer是Number类型的子类所以是可以添加的
     *
     * note ：
     *      <? super E> 用于写入或比较
     *      <?>、<? extends E> 用于读取
     */
    public void testTwo() {
        DynamicArray<Number> number = new DynamicArray<>();
        DynamicArray<Integer> inte = new DynamicArray<>();
        inte.add(1);
        inte.add(2);
        number.addAll(inte);
    }

    public void testThree() {
        DynamicArray<Number> number = new DynamicArray<>();
        DynamicArray<Integer> inte = new DynamicArray<>();
        inte.add(1);
        inte.add(2);
        number.addAllSimple(inte);
    }

    public void testCopyTo() {
        DynamicArray<Integer> ints = new DynamicArray<Integer>();
        ints.add(100);
        ints.add(34);
        DynamicArray<Number> numbers = new DynamicArray<Number>();
        ints.copyTo(numbers);
    }


}
