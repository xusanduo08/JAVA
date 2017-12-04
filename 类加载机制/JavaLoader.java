package com.mengfansheng.javaload;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �Զ����ļ�ϵͳ�������
 * **/
public class JavaLoader extends ClassLoader{
	//com.mengfansheng.test.User ==>D:/myjava/com/mengfansheng/test/User.class
	
	private String rootDir;
	
	public JavaLoader(String rootDir){
		this.rootDir = rootDir;
	}
	
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		Class<?> c = findLoadedClass(name);
		//�Ȳ�ѯ�Ƿ���ع����࣬����Ѿ����أ�ֱ�ӷ��أ�û�У�����ظ��ࡣ
		if(null != c){
			return c;
		} else {
			//ί�м��أ�ʹ�ø������
			ClassLoader parent = this.getParent();
			try{
				c = parent.loadClass(name);
			} catch(Exception e){
				//e.printStackTrace();
			}
			
			if(c != null){
				return c;
			} else {
				byte[] classData = null;
				try {
					classData = getClassData(name);//��ȡ����ֽ���
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(classData == null){
					throw new ClassNotFoundException();
				} else {
					c = defineClass(name, classData, 0, classData.length);
				}
			}
			
		}
		return c;
	}
	
	/**
	 * �������ֽ���
	 * **/
	private byte[] getClassData(String className) throws IOException{
		String path = this.rootDir + "/" + className.replace('.', '/') + ".class";
		InputStream is = new FileInputStream(path);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte[] buffer = new byte[1024];
		int temp = 0;
		while((temp = is.read(buffer)) != -1){
			baos.write(buffer, 0, temp);
		}
		is.close();
		return baos.toByteArray();
	}
	
	public static void main(String[] args){
		JavaLoader loader = new JavaLoader("E:/gg");
		JavaLoader loader2 = new JavaLoader("E:/gg");
		try {
			Class<?> c = loader.findClass("com.mengfansheng.test.Hi");
			Class<?> c1 = loader.findClass("com.mengfansheng.test.Hi");
			Class<?> c2 = loader2.findClass("com.mengfansheng.test.Hi");
			Class<?> c3 = loader2.findClass("java.lang.String");
			Class<?> c4 = loader2.findClass("com.mengfansheng.javaload.JavaLoader");
			
			System.out.println(c.hashCode());
			System.out.println(c1.hashCode());//ͬһ������������ص�ͬһ������ͬ
			System.out.println(c2.hashCode());//��ͬ����������ͬһ���಻ͬ
			
			//�Ƚϸ���ļ�����
			System.out.println(c2.getClassLoader());//�Զ���ļ����� com.mengfansheng.javaload.JavaLoader
			System.out.println(c3.getClassLoader());//�����������
			System.out.println(c4.getClassLoader());//Ӧ�ó����ࣨϵͳ�ࣩ������ sun.misc.Launcher$AppClassLoader
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
