package com.mengfansheng.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClient {

	public static void main(String[] args) throws IOException {
		//���������+�˿�
		DatagramSocket client = new DatagramSocket(6666);
		//׼������
		String msg = "UDP���";
		byte[] data = msg.getBytes();
		//������͵�ַ���˿�
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost",8888));
		//��������
		client.send(packet);
		//�ͷ�
		client.close();
	}

}
