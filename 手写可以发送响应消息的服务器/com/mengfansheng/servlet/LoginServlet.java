package com.mengfansheng.servlet;

import com.mengfansheng.server.Request;
import com.mengfansheng.server.Response;

/**
 * ��¼��Ӧ��Ϣ�ĵĹ�����
 * **/
public class LoginServlet extends Servlet {
	@Override
	public void doGet(Request req, Response rep) throws Exception {
		String name = req.getParamter("uname");
		String pwd = req.getParamter("pwd");
		
		if(login(name, pwd)){
			rep.print("<!DOCTYPE html><html><head><title>���ύ</title></head>");
			rep.print("<body>Hello,��ӭ").print(req.getParamter("uname")).print("</body></html>");
		} else {
			rep.print("<!DOCTYPE html><html><head><title>���ύ</title></head>");
			rep.print("<body>��¼ʧ��</body></html>");
		}
		
	}

	/**
	 * @desc �ж��û����������Ƿ���ȷ
	 * @param String name, String pwd
	 * @return boolean true ��¼�ɹ�  false��¼ʧ��
	 * **/
	public boolean login(String name, String pwd){
		if(null != name && null != pwd){
			return name.equals("admin") && pwd.equals("123456");
		}
		return false;
	}
	
	@Override
	public void doPost(Request req, Response rep) throws Exception {
		
	}
	
}
