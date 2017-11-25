package com.mengfansheng.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mengfansheng.bean.User;
/**
 * ʹ�÷��䶯̬�������
 * ��̬������Ͷ�������ⷽ����������
 * ��̬���úʹ�������
 * **/
public class Reflection03 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		String path="com.mengfansheng.bean.User";
		Class clazz = Class.forName(path);
		User u = (User)clazz.newInstance();//ʹ���޲ι�������ʼ������

		//ʹ��ָ����������ʼ������
		Constructor<User> c = clazz.getDeclaredConstructor(String.class, int.class, String.class);
		User u2 = c.newInstance("meng", 27, "programmer");
		
		//ʹ�÷���API������ͨ����
		Method method = clazz.getDeclaredMethod("setName", String.class);
		
		method.invoke(u, "fan");
		System.out.println(u.getName());
		
		//ͨ������API��������
		Field f = clazz.getDeclaredField("name");
		f.setAccessible(true);//����˽�����Կɲ���
		f.set(u2, "sheng");
		System.out.println(u2.getName());
	}
 
}
