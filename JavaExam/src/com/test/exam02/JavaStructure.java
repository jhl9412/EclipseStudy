package com.test.exam02; // package는 자바 파일의 최상단에

import java.util.Scanner; // import는 외부 패키지로부터 클래스를 가져온다.

public class JavaStructure {

	public static int sum(int a, int b) {
		
		return a+b;

	}

	
	public static void main(String[] args) {
		
		int i = 10;
		long l_value = 10l;
		double d_value = 10;
		float f_value = 10;
		
		System.out.println("Integer i = " + i + "\n" + 
		"long type l_value = " + l_value + "\n");
		System.out.println("Double d_value = " + 
		d_value + "\n" + "float f_value = " + f_value + "\n");
		
		String[] names = new String[3]; 
		// names 배열의 사이즈를 정해주고 new 예약어를 이용해 배열 생성.
		int size = names.length;
		
		Scanner put = new Scanner(System.in);
		// scanner는 사용자에게 직접 변수를 입력 받을 수 있도록 한다.
		for (int index=0; index<size; index++) {
			
			System.out.println("이름을 입력하세요.");
			names[index] = put.nextLine();
		//put 이라는 변수에 Scanner 클래스형을 선언해 클래스형의 메소드인 nextline을 
		//.을 이용해 사용한다 
		}
		
		for(int index=0; index<size ; index++)
			System.out.println("이름 : "+names[index]);
		
		put.close();
		
	}
}
