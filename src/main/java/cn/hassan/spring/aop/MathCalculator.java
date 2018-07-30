package cn.hassan.spring.aop;

public class MathCalculator {
	
	public Integer div(int i,int j){
		System.out.println("MathCalculator...div...");
		int a = i/j;
		return a;
	}

}
