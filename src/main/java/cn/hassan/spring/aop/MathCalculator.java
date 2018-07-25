package cn.hassan.spring.aop;

public class MathCalculator {
	
	public Integer div(int i,int j){
		System.out.println("MathCalculator...div...");
		int a = i/j;
		System.out.println("计算的结果是 ->" + a);
		return a;
	}

}
