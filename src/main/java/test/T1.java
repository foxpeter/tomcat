package test;

import java.io.FileInputStream;
import java.io.IOException;

public class T1 {

	public static void main(String[] args) {
		T1 t = new T1();
		//t.exc();
		System.out.println(t.test(2));
	}

	public void exc(){
		try{
			System.out.println("try start");
			String s = null;
			s.charAt(1);
			FileInputStream file = new FileInputStream("aa");
			
		}catch(IOException e){
			System.out.println("catch");
		}finally{
			System.out.println("finally");
		}
		System.out.println("after Exception");
	}
	
	public int test(int i){
		try{
			return i * i;
		}finally{
			return 999;
		}
	}
}
