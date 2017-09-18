package com.mengfansheng.IO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class SplitFile {

	public static void main(String[] args) throws IOException {

		SplitFile split = new SplitFile("E:/Git/ww.rmvb", 500000);
		split.split("E:/Git");
	}

	//�ļ�·��
	private String filePath;
	//�ļ���С
	private long length;
	
	//�ļ���
	private String fileName;
	//����
	private int size;
	//ÿһ���С
	private long blockSize;
	//ÿһ������
	private List<String> blockPath;
	
	public SplitFile(){
		blockPath = new ArrayList<String>();
	}
	
	public SplitFile(String filePath){
		this(filePath, 1024);
	}
	
	public SplitFile(String filePath, long blockSize){
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		init();
	}
	
	
	//��ʼ�������������ȷ���ļ���
	public void init(){
		File src = null;
		if(null == filePath || !((src = new File(filePath)).exists())){
			return;
		}
		if(src.isDirectory()){
			return;
		}
		
		//�ļ�����
		this.fileName = src.getName();
		//������� ʵ�ʴ�С ÿһ���С
		this.length = src.length();
		//���� ÿ���С
		if(this.blockSize > length){
			this.blockSize = length;
		}
		//ȷ������
		this.size = (int)Math.ceil(length*1.0 / this.blockSize);
	}
	
	//ÿһ������
	private void initPathName(String destPath){
		for(int i = 0; i < this.size; i++){
			this.blockPath.add(destPath + "/" + this.fileName + ".part" + i);
		}
	}
	
	/*
	 * �ļ��ָ�
	 * ��ʼλ��
	 * ʵ�ʴ�С
	 * */
	public void split(String dest) throws IOException{
		long beginPos = 0;
		long actualSize = blockSize;//ÿ��ʵ�ʴ�С
		initPathName(dest);
		for(int i  = 0; i< this.size; i++){
			if(i == this.size - 1){
				actualSize = this.length - beginPos;
			}
			splitDetail(i, beginPos, actualSize);
			beginPos += actualSize;//��һ�����
		}
	}
	
	private void splitDetail(int index, long beginPos, long actualSize) throws IOException{
		//����Դ
		File src = new File(this.filePath);
		File dest = new File(this.blockPath.get(index));
		//ѡ����
		RandomAccessFile raf;//������
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));//�����
		raf = new RandomAccessFile(src,"r");
		raf.seek(beginPos);
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = raf.read(flush))){
			
			if(actualSize - len >= 0){
				bos.write(flush, 0 , len);
				actualSize -= len;
			} else {
				bos.write(flush, 0 , (int)actualSize);
				break;
			}
		}
		bos.close();
		raf.close();
	}
	
}
