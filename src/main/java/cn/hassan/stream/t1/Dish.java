package cn.hassan.stream.t1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/23 17:11
 * Description:
 */
@Data
@AllArgsConstructor
public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public enum Type { MEAT, FISH, OTHER }
}
