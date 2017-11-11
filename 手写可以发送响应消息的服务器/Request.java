package com.mengfansheng.net;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Request(InputStream is){
		this();
		this.is = is;
		try {
			byte[] data = new byte[20480];
			int len;
			len = is.read(data);
			this.requestInfo = new String(data, 0, len);
			System.out.println(this.requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			CloseUtil.closeAll(is);
		}
		this.parseRequestInfo();
	}
	
	/**
	 * @desc ����������Ϣ
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
		
		if(this.method.equalsIgnoreCase("post")){
			this.url = urlString;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		} else {
			if(urlString.contains("?")){
				String[] urlArr = urlString.split("\\?");
				this.url = urlArr[0];
				paramString = urlArr[1];
			} else {
				this.url = urlString;
			}
		}
		
	}
}
