package com.mengfansheng.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class Convert {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(  //������
				new InputStreamReader(  //ת���ַ���������ָ�������ַ���
						new FileInputStream(new File("E:/Git/sss.txt")//�ֽ���
					)
				)
				
				);
		//д���ļ�
		BufferedWriter bf = new BufferedWriter(new FileWriter("E:/Git/ss.txt"));
		String info = null;
		while(null!=(info = br.readLine())){
			System.out.println(info);
		}
		br.close();
		
		
	}

}
