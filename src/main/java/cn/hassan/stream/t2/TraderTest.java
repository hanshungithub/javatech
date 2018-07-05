package cn.hassan.stream.t2;;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/24 10:33
 * Description:
 */
public class TraderTest {
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario","Milan");
	Trader alan = new Trader("Alan","Cambridge");
	Trader brian = new Trader("Brian","Cambridge");
	List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
	);
	@Test
	public void test01() {
		List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		collect.forEach(System.out::println);
	}

	@Test
	public void test02() {
		List<String> collect = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
		collect.forEach(System.out::println);
	}

	@Test
	public void test03() {
		List<Trader> cambridge = transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		cambridge.forEach(trader -> System.out.println(trader.getName()));
	}

	@Test
	public void test04() throws IOException {
		Stream<String> lines = Files.lines(Paths.get("src/main/resources/data.txt"), Charset.defaultCharset());
		long count = lines.flatMap(line -> Arrays.stream(line.split(""))).distinct().count();
		System.out.println(count);
	}
}
