package com.mengfansheng.reflection;

@SuppressWarnings("all")
public class Reflection01 {

	public static void main(String[] args) {
		String str = "com.mengfansheng.bean.User";
		try {
			/*
			 * һ���౻���غ�JVM�ᴴ��һ����Ӧ�����Class������������ṹ��Ϣ���ᱻ�ŵ���Ӧ��Class������
			 * ���Class�������һ�澵��һ����ͨ�����澵�ӾͿ��Կ�����Ӧ���ȫ����Ϣ
			 * ͬһ����ֻ�ᱻ����һ�Σ�ͬһ����ֻ����һ��Class����
			 * */
			Class clz = Class.forName(str);
			Class clz2 = Class.forName(str);//ͬһ����ֻ�ᱻ����һ�Σ���λ�ȡͬһ���࣬��ȡ��Ҳֻ��ͬһ��Class
			System.out.println(clz.hashCode());
			System.out.println(clz2.hashCode());
			
			int[] arr = new int[22];
			int[] arr1 = new int[33];
			double[] arr2 = new double[33];
			System.out.println(arr.getClass().hashCode());
			System.out.println(arr1.getClass().hashCode());//ͬ���͡�ͬά�ȵ������ȡ��Class������ͬ
			System.out.println(arr2.getClass().hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
