package cn.hassan.reflect;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/27 22:27
 * Description:
 */
public class MacBook {

    private String name;
    private double size;
    private double price;
    public String site;
    public int year;

	public MacBook(String name, double size, double price, String site, int year) {
		this.name = name;
		this.size = size;
		this.price = price;
		this.site = site;
		this.year = year;
	}

	public MacBook() {
    }

	public void sayString(String msg) {
		System.out.println("hello," + msg);
	}

	@Override
	public String toString() {
		return "MacBook{" +
				"name='" + name + '\'' +
				", size=" + size +
				", price=" + price +
				", site='" + site + '\'' +
				", year=" + year +
				'}';
	}
}
