package com.mengfansheng.server;

import java.util.HashMap;
import java.util.Map;

/**
 * Ϊ��ͬ�������ɲ�ͬ������
 * **/
public class ServletContext {
	private Map<String, String> servlet;
	private Map<String, String> mapping;
	
	public ServletContext(){
		//name -->����.����
		this.servlet = new HashMap<String, String>();
		//url -->name
		this.mapping = new HashMap<String, String>();
	}

	public Map<String, String> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
}
