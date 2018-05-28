package cn.hassan.lambda.t2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/23 14:19
 * Description:
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
	String process(BufferedReader reader) throws IOException;
}
