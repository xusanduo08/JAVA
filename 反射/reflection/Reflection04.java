package com.mengfansheng.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mengfansheng.bean.User;

/**
 * ����Ч�ʵıȽ�
 * ��ֹ��ȫ��������߷���������ٶ�
 * **/
public class Reflection04 {

	public static void test01(){
		User u = new User();
		
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 1000000000L; i++){
			u.getName();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("��ͨ�������ã�ִ��10�ڴΣ���ʱ" + (endTime - startTime) + "ms");
	}
	
	public static void test02() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		User u = new User();
		Class clazz = u.getClass();
		Method m = clazz.getDeclaredMethod("getName", null);
		//m.setAccessible(true);//��Ҫִ�з��ʰ�ȫ���
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 1000000000L; i++){
			m.invoke(u, null);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("���䶯̬�������ã�ִ��10�ڴΣ���ʱ" + (endTime - startTime) + "ms");
	}
	
	public static void test03() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		User u = new User();
		Class clazz = u.getClass();
		Method m = clazz.getDeclaredMethod("getName", null);
		m.setAccessible(true);//����Ҫִ�з��ʰ�ȫ���
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 1000000000L; i++){
			m.invoke(u, null);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("���䶯̬�������ã�������ȫ��飬ִ��10�ڴΣ���ʱ" + (endTime - startTime) + "ms");
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		test01();
		test02();
		test03();

	}

}
