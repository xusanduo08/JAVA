package com.mengfansheng.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileRead {

	public static void main(String[] args) throws IOException {
		//������ϵ��ѡ���ȡ�ļ���
		File src = new File("E:/Git/README.md");
		//ѡ����
		InputStream is = new FileInputStream(src);
		//��ȡ����
		int len = 0;
		//�����ֽ�����
		byte[] car = new byte[4];
		while(-1 != (len = is.read(car))){
			String str = new String(car,0,len);
			System.out.println(str);
		}
		if(null != is){
			is.close();
		}
		
	}

}
