package com.mengfansheng.javaload;

public class JavaLoad {

	/**
	 * ��ִ�о�̬�����
	 * Ȼ��ִ��A��Ĺ�����
	 * **/
	public static void main(String[] args) {
		A a = new A();
		System.out.println(A.width);
	}

}

class A{
	public static int width = 100;
	
	static{
		System.out.println("��̬��ʼ����A");
		width = 300;
	}
	
	public A(){
		System.out.println("����A��Ķ���");
	}
}