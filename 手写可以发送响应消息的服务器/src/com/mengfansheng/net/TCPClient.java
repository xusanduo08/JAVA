package com.mengfansheng.net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �����ͻ���  ָ���������Ͷ˿ڣ������Ĺ��̾������ӷ������Ĺ���
 * new Socket(String host, int port)
 * */
public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//�����ͻ���
		Socket client = new Socket("localhost", 5555);
		//��������+��������
		/*ʹ��BufferedReader��������
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String echo = br.readLine();//ע�⣬���͵�ʱ��Ҫ��newLine()����ʹ�ø÷���
		*/
		//ʹ��DataInputStream��������
		DataInputStream dis= new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
	}

}
