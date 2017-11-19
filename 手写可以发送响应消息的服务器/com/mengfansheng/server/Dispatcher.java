package com.mengfansheng.server;

import java.io.IOException;
import java.net.Socket;

import com.mengfansheng.net.CloseUtil;
import com.mengfansheng.servlet.Servlet;

/**
 * ʵ�ֽ�������Ӧ�Ķ��߳�
 * **/
public class Dispatcher implements Runnable{
	private Request req;
	private Response rep;
	private Socket client;
	private int code = 200;
	
	public Dispatcher(Socket client){
		this.client = client;
		try {
			req = new Request(this.client.getInputStream());
			rep = new Response(this.client.getOutputStream());
		} catch (IOException e) {
			code = 500;
			return;
		}
	}
	
	@Override
	public void run() {
		try {
			Servlet servlet = WebApp.getServlet(req.getUrl());
			if(null == servlet){
				this.code = 404;
			} else {
				servlet.service(req, rep); //��̬�ˣ��̳У����������ø��෽��
			}
		} catch (Exception e) {
			this.code = 500;
			e.printStackTrace();
		}
	
		rep.pushToClient(code);
		CloseUtil.closeAll(client);
		
	}

}
