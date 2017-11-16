package com.mengfansheng.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.mengfansheng.net.CloseUtil;

/*
 * ������������������
 * */
public class Tomcat {
	private ServerSocket server;
	private static final String CRLF = "\r\n";
	private static final String SPACE = " ";
	private boolean isShutdown = false;
	
	public static void main(String[] args) {
		Tomcat tomcat = new Tomcat();
		tomcat.start();
	}
	
	/**
	 * @desc ��Ĭ�϶˿�����������
	 * **/
	public void start(){
		start(8888);
	}
	
	/**
	 * @desc ����������
	 * @param ָ���˿�
	 * */
	public void start(int port){
		try {
			server = new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			stop();
		}
	}

	/**
	 * @desc ���տͻ�����Ϣ
	 * **/
	private void receive(){
		try {
			while(!isShutdown){
				Socket client = server.accept();
				//����Ϣ�ķ��ͺͽ��շ�װ���߳���
				Dispatcher dis = new Dispatcher(client);
				new Thread(dis).start();
			}
		} catch (IOException e) {
			this.stop();
		}
	}
	
	/**
	 * @desc ֹͣ������ 
	 * **/
	public void stop(){
		isShutdown = true;
		CloseUtil.closeAll(server);
	}
}
