package com.mengfansheng.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWrite {

	public static void main(String[] args) {
		//������ϵ��ѡ��Ŀ�ĵأ�
		File src = new File("E:/Git/ss.txt");
		OutputStream os = null;
		try {
			//ѡ���� 
			 os = new FileOutputStream(src, false);//true ׷����ʽд�� false �Ը�����ʽд��
			
			String str="�Ϸ�ʤ ";
			byte[] bytes = str.getBytes();//�ַ���ת�ֽ�����
			try {
				os.write(bytes, 0, bytes.length);
				os.flush();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("�ļ�д��ʧ��");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�δ�ҵ�");
		} finally {
			if(null != os){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
