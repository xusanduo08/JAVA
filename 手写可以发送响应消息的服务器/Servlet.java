package com.mengfansheng.net;
/**
 * @desc ��һ����װ�����������Ӧ���ݷ�װ������
 * **/
public class Servlet {
	public void service(Request req, Response rep){
		rep.print("<!DOCTYPE html><html><head><title>���ύ</title></head>");
		rep.print("<body>Hello,��ӭ").print(req.getParamter("uname")).print("</body></html>");
		rep.pushToClient(404);
	}
}
