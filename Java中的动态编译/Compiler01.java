package com.mengfansheng.Compiler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * Java�Ķ�̬�ı��빦��
 * **/

public class Compiler01 {
	public static void main(String[] args) throws FileNotFoundException{
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
	}
}
