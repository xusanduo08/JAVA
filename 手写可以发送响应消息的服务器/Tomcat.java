package com.mengfansheng.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/*
 * ������������������
 * */
public class Tomcat {
	private ServerSocket server;
	private static final String CRLF = "\r\n";
	private static final String SPACE = " ";
	public static void main(String[] args) {
		Tomcat tomcat = new Tomcat();
		tomcat.start();
	}
	
	//����������
	public void start(){
		try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//���տͻ�����Ϣ
	private void receive(){
		try {
			Socket client = server.accept();
			//��ȡ������Ϣ
			Request req = new Request(client.getInputStream());
			
			StringBuilder responseContent = new StringBuilder();
			//������Ӧ��Ϣ
			Response rep = new Response(client.getOutputStream());
			rep.print("<!DOCTYPE html><html><head><title>���ύ</title></head><body>Hello</body></html>");
			rep.pushToClient(404);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	//ֹͣ������
	public void stop(){
		
	}
}
