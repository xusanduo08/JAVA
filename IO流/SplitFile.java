package com.mengfansheng.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.omg.CORBA_2_3.portable.InputStream;

public class SplitFile {

	public static void main(String[] args) throws IOException {

		SplitFile split = new SplitFile("E:/gg/ff.rmvb", 5000000,"E:/gg");
		//split.split();
		//split.mergeFile("E:/gg/merge/gg.rmvb");
		split.merge("E:/gg/merge/ggg.rmvb");
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
	//�ָ���·��
	private String destPath;
	
	public SplitFile(){
		blockPath = new ArrayList<String>();
	}
	
	public SplitFile(String filePath,String destPath){
		this(filePath, 1024, destPath);
	}
	
	public SplitFile(String filePath, long blockSize, String destPath){
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		this.destPath = destPath;
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
		initPathName();
	}
	
	//�����ÿһ������
	private void initPathName(){
		for(int i = 0; i < this.size; i++){
			this.blockPath.add(this.destPath + "/" + this.fileName + ".part" + i);
		}
	}
	
	/*
	 * �ļ��ָ�
	 * ��ʼλ��
	 * ʵ�ʴ�С
	 * */
	public void split() throws IOException{
		long beginPos = 0;
		long actualSize = blockSize;//ÿ��ʵ�ʴ�С
		
		for(int i  = 0; i< this.size; i++){
			if(i == this.size - 1){
				actualSize = this.length - beginPos;
			}
			splitDetail(i, beginPos, actualSize);
			beginPos += actualSize;//��һ����� = ������� + ���ηָ�Ĵ�С
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
		raf.seek(beginPos); // ��beginPos��ʼ��ȡ
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = raf.read(flush))){
			
			if(actualSize - len >= 0){ // ���ʣ����ָ����ݣ�actualSize��С��flush��С��˵������ֻ��д��actualSize��С������
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
	
	public void mergeFile(String destPath) throws IOException{
		//����Դ
		File dest = new File(destPath);
		//ѡ����
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		bos = new BufferedOutputStream(new FileOutputStream(dest,true));//׷�ӷ�ʽд��
		for(int i = 0; i < this.blockPath.size(); i++){
			File blockFile = new File(this.blockPath.get(i));
			if(!blockFile.exists() || blockFile.isDirectory()){
				System.out.println("���ȷָ��ļ���ϲ�");
				return;
			}
			bis = new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i))));
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1 != (len = bis.read(flush))){
				bos.write(flush, 0, len);
			}
			
			FileClose.close( bis);
		}
		
		FileClose.close(bos);
	}
	
	
	public void merge(String destPath) throws IOException{
		Vector<BufferedInputStream> vi = new Vector<BufferedInputStream>();
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(destPath),true));
		System.out.println(this.blockPath.size());
		for(int i = 0;i < this.blockPath.size(); i++){
			BufferedInputStream bis = null;
			try {
				File blockFile = new File(this.blockPath.get(i));
				if(blockFile.exists() && !blockFile.isDirectory()){
					bis = new BufferedInputStream(new FileInputStream(blockFile));
					vi.add(bis);
				} else {
					System.out.println("���Ƚ��зָ��ļ�����,Ȼ���ٽ����ļ��ϲ�");
					return;
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		SequenceInputStream sis = new SequenceInputStream(vi.elements());
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = sis.read(flush))){
			bos.write(flush, 0, len);
		}
		bos.flush();
		FileClose.close(sis,bos);
	}
}
