package com.mengfansheng.net;

import java.util.HashMap;
import java.util.Map;

/**
 * Ϊ��ͬ�������ɲ�ͬ������
 * **/
public class ServletContext {
	private Map<String, Servlet> servlet;
	private Map<String, String> mapping;
	
	public ServletContext(){
		//name -->servlet
		this.servlet = new HashMap<String, Servlet>();
		//url -->name
		this.mapping = new HashMap<String, String>();
	}

	public Map<String, Servlet> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, Servlet> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
}
