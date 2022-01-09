package exam;

import java.util.Map;

public class SingleTonMain {
	private int a;
	private static int b;
	
	public static void main(String[] args) {
		SingleTonMain aa = new SingleTonMain();
		aa.a++;//1
		aa.b++;//1
		System.out.println("a="+aa.a+"     b="+aa.b);
		
		SingleTonMain bb = new SingleTonMain();
		bb.a++;//1
		bb.b++;//2
		System.out.println("a="+bb.a+"     b="+bb.b);
		
		SingleTonMain cc = new SingleTonMain();
		cc.a++;//1
		cc.b++;//3
		System.out.println("a="+cc.a+"     b="+cc.b);
		
	}

}
