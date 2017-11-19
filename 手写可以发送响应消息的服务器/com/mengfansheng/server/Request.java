package com.mengfansheng.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.mengfansheng.net.CloseUtil;

/*
 * ����������
 * */
public class Request {
	//����ʽ
	private String method;
	//������Դ
	private String url;
	//�������
	private Map<String, List<String>> paramter;
	
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	
	//����������������л�ȡ�ͻ���������Ϣ
	private InputStream is;
	//�洢������Ϣ
	private String requestInfo;
	
	public Request(){
		this.method = "";
		this.url = "";
		this.paramter = new HashMap<String, List<String>>();
		this.requestInfo = "";
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Request(InputStream is){
		this();
		this.is = is;
		try {
			byte[] data = new byte[20480];
			int len;
			len = is.read(data);
			this.requestInfo = new String(data, 0, len);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("============");
			CloseUtil.closeAll(is);
		}
		this.parseRequestInfo();
	}
	
	/**
	 * @desc ����������Ϣ,�����������Ρ����󷽷����Լ�����·��
	 * **/
	private void parseRequestInfo(){
		//��ֹ��ָ���쳣
		if(null == requestInfo || (requestInfo.trim()).equals("")){
			return;
		}
		
		/**
		 * �����н����� ���󷽷� ����·�� �������
		 * post����ʽ�������λ����󣬻���û��
		 * **/
		//�洢�������
		String paramString = "";
		
		//������Ϣ����
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		int index = firstLine.indexOf("/");
		this.method = firstLine.substring(0, index).trim();
		
		//�洢��Դ·��
		String urlString = firstLine.substring(index, firstLine.indexOf("HTTP")).trim();
		
		//equalsIgnoreCase ���Դ�Сд
		if(this.method.equalsIgnoreCase("post")){
			this.url = urlString;
			//�����post������ô�������������ĵ����һ��
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		} else {
			//get���󣬲�������?֮��
			if(urlString.contains("?")){
				String[] urlArr = urlString.split("\\?");
				this.url = urlArr[0];
				paramString = urlArr[1];
			} else {
				this.url = urlString;
			}
		}
		
		if(!paramString.equals("")){
			this.parseParams(paramString);
		}
	}
	
	/**
	 * @desc �������������map��   key=value&key1=value1&key2=value2
	 * @param  ����ַ���
	 * **/
	private void parseParams(String paramString){
		StringTokenizer token = new StringTokenizer(paramString, "&");
		while(token.hasMoreTokens()){
			String keyValue = token.nextToken();
			String[] keyValues = keyValue.split("=");
			if(keyValues.length == 1){
				keyValues = Arrays.copyOf(keyValues, 2);
				keyValues[1] = null;
			}
			
			String key = keyValues[0].trim();
			String value = null == keyValues[1] ? null : decode(keyValues[1].trim(), "gbk");
			
			if(!this.paramter.containsKey(key)){
				paramter.put(key, new ArrayList<String>());
			}
			
			List<String> values = paramter.get(key);
			values.add(value);
		}
	}
	
	/**
	 * @desc����name��ȡ��Ӧ�Ķ��ֵ
	 * @param String name Ҫ��ȡ��ֵ�ļ�
	 * @return ֵ
	 * **/
	public String[] getParamters(String name){
		List<String> values = null;
		if((values = this.paramter.get(name)) == null){
			return null;
		} else {
			return values.toArray(new String[0]);
		}
	}
	
	/**
	 * ����name��ȡ��Ӧ�ĵ���ֵ
	 * @param String name Ҫ��ȡ��ֵ�ļ�
	 * @return ��Ӧname��ֵ
	 * **/
	public String getParamter(String name){
		String[] values = this.getParamters(name);
		if(null == values){
			return null;
		} else {
			return values[0];
		}
	}
	
	/**
	 * @desc �������ı���
	 * @param String value������ֵ, String code ����
	 * @return �����������ַ��� 
	 * **/
	private String decode(String value, String code){
		try {
			return java.net.URLDecoder.decode(value, code);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
