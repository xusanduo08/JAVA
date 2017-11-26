package com.mengfansheng.Compiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * Java�Ķ�̬�ı��빦��
 * **/

public class Compiler01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//��α���һ���ַ�����=��ͨ��IO�������ַ����洢���ļ��У�Ȼ����ö�̬���뷽��
		String str="public class Hi{public static void main(String[] args){System.out.println(\"haha\");}}";
		String path = "e:"+java.io.File.separator+"gg"+java.io.File.separator+"Hi.java";
		OutputStream os = new FileOutputStream(path);
		byte[] bytes = str.getBytes();
		try {
			os.write(bytes, 0, bytes.length);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�д��ʧ��");
		}
		
		int result = compiler.run(null, null, null, "c:"+java.io.File.separator+"gg" + java.io.File.separator +"HelloWorld.java");
		int result1 = compiler.run(null, null, null, path);
		System.out.println("�ļ�1������ " + result);
		System.out.println("�ļ�2������ " + result1);
		
		//ͨ��Runtime.getRuntime()��̬���б���õ���
		Runtime run = Runtime.getRuntime();
		Process process = run.exec("java -cp c:/gg  HelloWorld");
		
		InputStream in = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String info = "";
		while(null !=(info = reader.readLine())){
			System.out.println(info);
		}
		
		//ͨ���������б���õ���
		URL[] urls = new URL[] {new URL("file:/" + "c:/gg/")};
		URLClassLoader loader = new URLClassLoader(urls);
		Class c = loader.loadClass("HelloWorld");
		//�������������main����
		Method m = c.getMethod("main", String[].class);
		m.invoke(null, (Object)new String[]{"aa", "bb"});//main�����Ǹ���̬���������Բ��ö���ȥ���ã�������ط����Դ���null
		//��Ҫʹ��Objectǿתһ�²������ͣ�������ӣ��ᱻ�����m.invoke(null, "aa", "bb")����ͷ����˲���������ƥ�������
		
	}
}
