package com.mengfansheng.net;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ������������ָ���˿�
 * ��ͬЭ��֮��˿ںſ����ظ�
 * */
public class TCPServer {

	public static void main(String[] args) throws IOException {
		//����������
		ServerSocket server = new ServerSocket(5555);
		//���տͻ������ӣ�����ʽ
		Socket socket = server.accept();
		//��������+��������
		
		String msg = "��ӭʹ��";
		/*ʹ��BufferedWriter��������
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();//ע����ط���������仰�����յ�ʱ�����ʹ��readLine()����
		bw.flush();
		*/
		//ʹ��DataOutputStream��������
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		System.out.println("һ���ͻ��˽�������");
	}

}
