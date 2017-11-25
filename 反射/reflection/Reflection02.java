package com.mengfansheng.reflection;
/**
 * ʹ�÷����ȡ��������ԡ�������������
 * **/
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection02 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		String path="com.mengfansheng.bean.User";
		Class clz = Class.forName(path);
		
		System.out.println(clz.getName());//��ð���+����
		System.out.println(clz.getSimpleName());//�������
		
		//�������
		Field[] fields = clz.getFields();//ֻ�ܻ�ȡpublic����
		System.out.println(fields.length);
		Field[] fields2 = clz.getDeclaredFields(); //��ȡ��������
		System.out.println(fields2.length);
		for(Field temp:fields2){
			System.out.println(temp);
		}
		try {
			Field f = clz.getDeclaredField("name");// ��ȡָ������
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		//��ȡ����
		Method[] methods = clz.getMethods();
		Method method = clz.getMethod("getName");
		Method method1 = clz.getMethod("setName", String.class);
		for(Method m:methods){
			System.out.println(m);
		}
		
		//��ȡ������
		Constructor[] constructors = clz.getDeclaredConstructors();
		Constructor constructor = clz.getDeclaredConstructor(String.class, int.class, String.class);
		System.out.println(constructor);
		for(Constructor c:constructors){
			System.out.println(c);
		}
	}

}
