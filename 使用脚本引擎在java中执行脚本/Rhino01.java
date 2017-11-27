package com.mengfansheng.rhino;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * ����ʹ�ýű�����ִ��javascript����
 * 
 * **/
public class Rhino01 {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException{
		//��ýű��������
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//�������,�洢������������
		engine.put("msg", "sanduo is a good man!");
		String str = "var user = {name:'sanduo', age:20, work:'soldier'};";
		str += "print(user.name);";
		
		//ִ�нű�
		engine.eval(str);
		//�洢�ı����ȿ��Ա�js�ű�������Ҳ���Ա�java������Ҳ����˵����Ŀ�нű������н����java��ȡ
		//���Կ���ʹ�ýű���һЩ��������������������java����ȡ������������������˴���������
		engine.eval("msg = 'fansheng is a good man!'");
		System.out.println(engine.get("msg"));
		System.out.println("####################################");
		
		//����js�еĺ���
		engine.eval("function add(a, b){return a+b;};");
		// ȡ�õ��ýӿ�
		Invocable jsInvoke = (Invocable)engine;
		//ִ�нű��ж���ķ���
		Object result = jsInvoke.invokeFunction("add", new Object[]{12, 30});
		System.out.println(result);
		
		//ϣ���ڵ��ýű�����ʱ��ȡ��java�е�һЩ��ͷ�������ʱ����ô�죿
		//java����+����+��������
		String jsCode = " var list = java.util.Arrays.asList([\"������\",\"�೤\",\"�ɲ�\"]);";
		engine.eval(jsCode);
		
		List<String> list2 = (List<String>)engine.get("list");
		for(String temp:list2){
			System.out.println(temp);
		}
		
		//ִ��һ���ⲿ��js�ļ�
		URL url = Rhino01.class.getClassLoader().getResource("run.js");
		
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();
	}
}
