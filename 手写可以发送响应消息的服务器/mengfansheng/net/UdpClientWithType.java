package com.mengfansheng.net;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClientWithType {

	public static void main(String[] args) throws IOException {
		//���������+�˿�
		DatagramSocket client = new DatagramSocket(6666);
		//׼������
		double num = 89.12;
		byte[] data = convert(num);
		//������͵�ַ���˿�
		DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 8888);
		//��������
		client.send(packet);
		//�ͷ�
		client.close();
		
		//read(write());

	}
	
	public static byte[] convert(double num) throws IOException{
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		data = bos.toByteArray();
		dos.close();
		return data;
	}
	
	public static byte[] write() throws IOException{
		byte[] dest;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "�ֽ�����";
		byte[] info = msg.getBytes();
		bos.write(info, 0, info.length);
		dest = bos.toByteArray();
		bos.close();
		
		return dest;
	}
	
	public static void read(byte[] data) throws IOException{
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush, 0, flush.length))){
			System.out.println(new String(flush, 0, flush.length));
		}
		is.close();
		
	}

}
