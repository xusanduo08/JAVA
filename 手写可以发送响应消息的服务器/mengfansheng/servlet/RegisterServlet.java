package com.mengfansheng.servlet;

import com.mengfansheng.server.Request;
import com.mengfansheng.server.Response;

/**
 * ע��Ĺ�����
 * **/
public class RegisterServlet extends Servlet {

	@Override
	public void doGet(Request req, Response rep) throws Exception {
		
	}

	@Override
	public void doPost(Request req, Response rep) throws Exception {
		rep.print("<!DOCTYPE html><html><head><title>ע����</title></head>");
		rep.print("<body>Hello,��ӭ").print(req.getParamter("uname")).print(" ע��ɹ�</body></html>");
		
	}

}
