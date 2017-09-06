package com.mengfansheng.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		File src = new File("E:/Git/README.md");
		File dest = new File("E:/Git/README.md.cp");
		
		try {
			FileCopy("E:/Git/README.md","E:/Git/README.md.cp1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*�ļ�����
	 * srcPath Դ�ļ�·��
	 * destPath Ŀ���ļ�·��
	 * */
	public static void FileCopy(String srcPath, String destPath) throws IOException{
		
		FileCopy(new File(srcPath), new File(destPath));
	}
	/*�ļ�����
	 * src Դ�ļ�����
	 * dest Ŀ���ļ�����
	 * */
	public static void FileCopy(File src, File dest) throws IOException{
		if(!src.isFile()){
			throw new IOException("ֻ�ܿ����ļ�");
		}
		
		if(src.isDirectory()){
			throw new IOException("������һ���ļ���·��");
		}
		
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		
		byte[] data = new byte[10];
		int len = 0;
		
		while(-1 != (len = is.read(data))){
			//д��
			os.write(data,0, len);
		}
		os.flush();//��ˢ�ܵ�
		os.close();//�ر���
		is.close();
	}
	
}
