package com.mengfansheng.server;

import java.util.ArrayList;
import java.util.List;

/**
 * ʵ���࣬�洢
 * <servlet-name>login</servlet-name>
	<url-pattern>/login</url-pattern>
 * **/
public class Mapping {
	private String name;
	//һ��name���ܶ�Ӧ���url��������ط��ø�List�����洢
	private List<String> urlPattern;
	
	public Mapping(){
		urlPattern = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(List<String> urlPattern) {
		this.urlPattern = urlPattern;
	}
	
}
