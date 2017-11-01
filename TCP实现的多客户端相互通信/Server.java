package com.mengfansheng.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	public static void main(String[] args) throws IOException {
		new Server().start();
	}
	
	//ʹ�������������пͻ���
	private List<Channel> all = new ArrayList<Channel>();
	
	
	public void start() throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while(true){	
			Socket client = server.accept();
			Channel channel = new Channel(client);
			all.add(channel); //�����������ӵĿͻ�����ӵ������б��ڹ���
			new Thread(channel).start();
		}
	}

	/*
	 * �ͻ�����  �Ǿ�̬�ڲ��� ���������һ���ⲿ����
	 * ÿ���ͻ��˶�ռһ���߳�
	 * */
	private class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		private String name;
		
		public Channel(Socket client){
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name = dis.readUTF();
				this.send(this.name + "��ӭ����������");  //��ӭ�Լ�����������
				this.sendAll(this.name + "����������");  //�������������˽���������
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dis, dos);
			}
		}
		
		private String receive(){
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dis, dos);
				all.remove(this);//�����쳣���Ƴ�����
			}
			
			return msg;
		}
		
		private void send(String msg){
			if(null != msg || !msg.equals("")){
				try {
					dos.writeUTF(msg);
					dos.flush();
				} catch (IOException e) {
					e.printStackTrace();
					isRunning = false;
					CloseUtil.closeAll(dis, dos);
					all.remove(this);//�����쳣���Ƴ�����
				}
				
			}
		}
		
		private void sendAll(String msg){
			
			//��������������Ϣ���͵������ͻ���
			for(Channel other:all){
				if(other == this){
					continue;
				}
				other.send(msg);
			}
		}
		
		@Override
		public void run() {
			while(isRunning){
				String msg = this.receive();
				sendAll(msg);
			}
		}
		
	}
	
}
