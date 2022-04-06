package com.test.exam02;

import java.util.Arrays;

public class ArrayExam {

	public static void main(String[] args) {
		
		int[] a = new int[] {1,2,3,4,5,6}; //array 생성
		
		for (int i = 0;i < a.length; i++) { // a 배열의 길이 .length를 이용해 구한다.
			
			System.out.print(a[i]+" "); // a 배열을 for 문을 이용해 하나씩 출력
		}
		
		System.out.print("\n===============\n");
		
		for (int i: a) System.out.print(i + " "); //향상된 for문
		// 정수형 i 에 배열 a를 차례대로 대입
		System.out.print("\n===============\n");
		System.out.println(Arrays.toString(a)); 
		//Arrays 객체의 toString 메소드는 대괄호 [] 안에 배열을 넣고 반환한다.
		
		int[][] b = {{1,2,3},{4,5,6}, {7,8,9}}; // array  생성
		
		for (int i = 0;i< b.length; i++) {
			for(int j =0;j< b[1].length; j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println("");
			
		}
		for(int i =0 ; i<b.length; i++)
			System.out.println(Arrays.toString(b[i]));
		
		//조건문
		int c = 6;
		
		if(c<5) System.out.println("작다"); // if, else if 구문
		else if(c>3) System.out.println("크다");
		
		//switch case
		int d = 3;
		String str = "Hot";
		switch(str) { // 만약 (변수)가
		case "Cold" : System.out.println("춥습니다");// Cold 라면
				 break;
		case "Hot!" : System.out.println("덥습니다");// Hot 이면
				 break;
		default : System.out.println("졸립니다"); // case에 아무것도 없다면 default 값.
		}
		
		System.out.println("이것도 특별한 거 없어요.");
		
	}

}
