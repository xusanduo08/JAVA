package com.mengfansheng.IO;


import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class PStream {

	public static void main(String[] args) throws FileNotFoundException {
		//������ļ�
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("E:/Git/tt.txt")),true));//�Զ�ˢ��
		
		System.out.println("������ļ�");
		
		//�������������̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		
	}

}
