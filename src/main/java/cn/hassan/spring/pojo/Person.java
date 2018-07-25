package cn.hassan.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with idea
 * Author: hss
 * Date: 7/25/2018 2:26 PM
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	private String name;
	private Integer age;
	private String nickName;
}
