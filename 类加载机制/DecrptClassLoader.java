package com.mengfansheng.javaload;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ��class�ֽ�����ܣ�ȡ������ʹ��������������޷����أ�����ʾjava.lang.ClassFormatError���ʽ����ȷ
 * ʹ���������������������أ�ԭ����Ƕ�ȡ�ֽ�����ֽ�����һ��ȡ������
 * �����ļ�ϵͳ�м��ܺ��class�ֽ�����������
 * */
public class DecrptClassLoader extends ClassLoader {

	private String rootDir;//�洢�ļ��ĸ�Ŀ¼
	
	public DecrptClassLoader(String rootDir){
		this.rootDir = rootDir;
	}
	/**
	 * @param String com.mengfansheng.test.User һ��java��ȫ��
	 * @return Class
	 * */
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);//��ȷ��Ҫ���ص����Ƿ��Ѿ�����
		
		if(null != c){
			return c;
		} else {
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name);
			} catch (ClassNotFoundException e) {
				//
			}
			if(null != c){
				return c;
			} else {
				byte[] classData = getClassData(name);
				if(null ==  classData){
					throw new ClassNotFoundException();
				} else {
					c = defineClass(name, classData, 0, classData.length);
				}
			}
		}
		return c;
	}
	
	/**
	 * @param String com.mengfansheng.test.User һ��java��ȫ��
	 * @return byte[]
	 * */
	private byte[] getClassData(String classname){
		String path = rootDir + "/" + classname.replace('.', '/') + ".class";
		
		InputStream is = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		try {
			is = new FileInputStream(path);
			
			int temp = -1;
			while((temp = is.read()) != -1){
				bos.write(temp^0xff);//ȡ������
			}
			return bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
		
	}
	
}
