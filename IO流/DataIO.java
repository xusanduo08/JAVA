package com.mengfansheng.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIO {

	public static void main(String[] args) throws IOException {
		//�������ʹ�������������������+String
		
		byte[] data = write();
		read(data);
	}
	
	//���ֽ������ȡ����+����
	public static void read(byte[] src) throws IOException {
		
		DataInputStream dis = new DataInputStream(
					new BufferedInputStream(new ByteArrayInputStream(src))
				);
		//��ȡ˳����д��˳��һ�� �ұ�����ڲ��ܶ�ȡ
		
		double num = dis.readDouble();
		long num1 = dis.readLong();
		String str = dis.readUTF();
		dis.close();
		System.out.println(num+" "+num1+" "+str);
	}

	/*
	 * ����+����������ֽ�����
	 * */
	
	public static byte[]  write() throws IOException{
		byte[] dest = null;
		double point = 2.3;
		long num = 100L;
		String str = "��������";
		
		//����Դ
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(
								bos
							)
				);
		
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dest = bos.toByteArray();
		bos.close();
		return dest;
	}
}
