package com.mengfansheng.IO;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class PStream {

	public static void main(String[] args) throws FileNotFoundException {
		//������ļ�
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("E:/Git/tt.txt")),true));//�Զ�ˢ��
		
		System.out.println("������ļ�");
		
		//�������������̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		
		//���ñ�׼���������ļ�����
		System.setIn(new BufferedInputStream(new FileInputStream(new File("E:/Git/tt.txt"))));
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLine());
		
		//���ñ�׼�����������̨����
		System.setIn(new BufferedInputStream(new FileInputStream(FileDescriptor.in)));
		
	}

}
