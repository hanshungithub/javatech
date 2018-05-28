package cn.hassan.stream.t2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 10:31
 * Description:
 */
@Data
@AllArgsConstructor
public class Transaction {
	private final Trader trader;
	private final int year;
	private final int value;
}
