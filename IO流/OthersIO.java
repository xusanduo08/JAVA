package com.mengfansheng.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OthersIO {

	public static void main(String[] args) throws IOException {
		
		read(write());
		byte[] data = getBytesFromFile("E:/Git/sss.txt");
		
		/*	�ļ�����
		 *  �ļ�����===���ֽ�����
		 * 	  ||         ||
		 * �ļ�������       �ֽ����������
		 * 	�ֽ�����===��        �ļ�
		 *    ||          || 
		 * �ֽ�����������     �ļ������
		 * 
		 * */
		toFileFromByteArray(data, "E:/Git/mm.txt");
	}
	
	public static void toFileFromByteArray(byte[] src, String destPath) throws IOException{
		File dest = new File(destPath);
		//�ֽ�����������
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//�ļ������
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		
		//���϶�ȡ�ֽ�����
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
			os.write(flush,0, len);
		}
		os.flush();
		os.close();
		is.close(); 
	}
	
	public static byte[] getBytesFromFile(String srcPath) throws IOException{
		File src = new File(srcPath);
		byte[] dest = null;
		
		InputStream is = new BufferedInputStream(
					new FileInputStream(src)
				);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//���϶�ȡ�ļ���д�����ֽ�������
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
			bos.write(flush, 0 , len);
		}
		bos.flush();
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
	}
	
	
	public static void read(byte[] src) throws IOException{
		
		
		InputStream is = new BufferedInputStream(
					new ByteArrayInputStream(src)
				);
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
			System.out.println(new String(flush, 0, len));
		}
		is.close();
	}
	public static byte[] write() throws IOException {
		byte[] dest;
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "�������ļ�����һ��";
		byte[] info = msg.getBytes();
		bos.write(info,0,info.length);
		
		dest = bos.toByteArray();
		bos.close();
		
		return dest;
	}

}
