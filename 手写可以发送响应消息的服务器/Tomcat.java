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

	//���տͻ���
	private void receive(){
		try {
			Socket client = server.accept();
			
			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			String msg = new String(data, 0, len);//���տͻ���������Ϣ
			
			//���տͻ���������Ϣ
			System.out.println(msg);
			
			StringBuilder responseContent = new StringBuilder();
			responseContent.append("<!DOCTYPE html><html><head><title>���ύ</title></head><body>Hello</body></html>");
			//������Ӧ��Ϣ
			StringBuilder response = new StringBuilder();
			//HTTPЭ��汾��״̬�롢����
			response.append("HTTP/1.1").append(this.SPACE).append("200 ok").append(CRLF);
			//��Ӧͷ
			response.append("Server:BWS/1.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-Type:text/html;charset=GBK").append(CRLF);
			//���ĳ���--�ֽ���
			response.append("Content-Length:").append(responseContent.toString().getBytes().length).append(CRLF);
			
			response.append(CRLF);//��һ�У���ʼ����
			
			//����
			response.append(responseContent).append(CRLF);
			
			//�����
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//ֹͣ������
	public void stop(){
		
	}
}
