package test_1;

import org.junit.Test;

public class TestMiracle {

	@Test
	public void test_1(){
		int i=0;
		for(i=0;i<10;i++){
			System.out.println("========:  "+i);
		}
		System.out.println(i);
	}
	
	@Test
	public void test_2(){
		StringBuilder sb=new StringBuilder("sssss");
		System.out.println(sb.indexOf("_"));
	}
	
}
