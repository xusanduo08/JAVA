package com.mengfansheng.javaload;
/**
 * �������֮��Ĺ�ϵ
 * **/
public class JavaLoad1 {

	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());//sun.misc.Launcher$AppClassLoader@4e0e2f2a  Ӧ���������
		System.out.println(ClassLoader.getSystemClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@2a139a55  ��չ�������
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//null���������������Cʵ�֣�java�л�ȡ������������ط���null

		//C:\Users\Administrator\workspace\JavaLoad\bin��Ҳ����˵����ǰϵͳ�������ʱ���ǰ������·�����ص�
		//���·��������Ŀ�Ƕ����ģ���������ʱ��Ŀ֮�䲻���໥Ӱ��
		System.out.println(System.getProperty("java.class.path"));
	}

}
