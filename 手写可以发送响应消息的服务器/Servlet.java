package com.mengfansheng.net;
/**
 * @desc ��һ����װ�����������Ӧ�������ɶ�����װ������
 * **/
public class Servlet {
	
	/**
	 * @desc ƴ����Ӧ��Ϣ��
	 * @param Request req, Response rep
	 * 
	 * **/
	public void service(Request req, Response rep){
		rep.print("<!DOCTYPE html><html><head><title>���ύ</title></head>");
		rep.print("<body>Hello,��ӭ").print(req.getParamter("uname")).print("</body></html>");
	}
}
