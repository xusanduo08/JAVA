package com.mengfansheng.IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class InFromFile {

	public static void main(String[] args) throws FileNotFoundException {
		//��׼�������� ==�� ���ļ�����
		InputStream is = System.in;
		is = new BufferedInputStream(new FileInputStream(new File("E:/Git/rr.txt")));
		Scanner sc = new Scanner(is);
		System.out.println(sc.nextLine());
	}

}
