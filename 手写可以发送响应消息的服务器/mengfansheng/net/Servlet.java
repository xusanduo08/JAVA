package com.mengfansheng.net;

import com.mengfansheng.server.Request;
import com.mengfansheng.server.Response;

/**
 * @desc һ�������࣬��������̳�ȥ���ɶ�Ӧ��ͬ�����ĵķ�����Ϣ
 * **/
public abstract class Servlet {
	
	/**
	 * @desc ƴ����Ӧ��Ϣ��
	 * @param Request req, Response rep
	 * @throws Exception 
	 * **/
	public void service(Request req, Response rep) throws Exception{
		this.doGet(req, rep);
		this.doPost(req, rep);
	}
	
	public abstract void doGet(Request req, Response rep) throws Exception;
	public abstract void doPost(Request req, Response rep) throws Exception;
}
