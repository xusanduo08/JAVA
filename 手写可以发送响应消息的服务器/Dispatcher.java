package com.mengfansheng.net;

import java.io.IOException;
import java.net.Socket;

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
		//��������Ӧ��Ϣ���ɶ�����װ������
		Servlet servlet = new Servlet();
		servlet.service(req, rep);
	
		rep.pushToClient(code);
		CloseUtil.closeAll(client);
		
	}

}
