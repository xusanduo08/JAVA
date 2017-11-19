package com.mengfansheng.net;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerWithType {

	public static void main(String[] args) throws IOException {
		//���������+ָ���˿�
		DatagramSocket server = new DatagramSocket(8888);
		//׼������
		byte[] container = new byte[1024];
		//��װ�ɰ�
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		//��������
		server.receive(packet);
		//��������
		byte[] data = packet.getData();
		double num = convert(data);
		System.out.println(num);
		//�ͷ���Դ
		server.close();

	}
	
	public static double convert(byte[] data) throws IOException{
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = dis.readDouble();
		dis.close();
		return num;
	}

}
