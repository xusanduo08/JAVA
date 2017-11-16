package com.mengfansheng.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * UDP�����
 * */
public class UdpServer {

	public static void main(String[] args) throws IOException {
		//���������+ָ���˿�
		DatagramSocket ds = new DatagramSocket(6666);
		//׼������
		byte[] container = new byte[1024];
		//��װ�ɰ�
		DatagramPacket packet = new DatagramPacket(container, container.length);
		//��������
		ds.receive(packet);
		//��������
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data, 0, len));
		
		//�ͷ���Դ
		ds.close();
	}

}
