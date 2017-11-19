package com.mengfansheng.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

import com.mengfansheng.net.CloseUtil;

/*
 * ��װ��Ӧ��Ϣ
 * */

public class Response {
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	
	//�����
	private BufferedWriter bw;
	
	//�洢��Ӧ��
	private StringBuilder content;
	
	//�洢��Ӧͷ
	private StringBuilder headInfo;
	private int len;
	
	public Response(){
		this.headInfo = new StringBuilder();
		this.content = new StringBuilder();
		this.len = 0;
	}
	
	public Response(OutputStream os){
		this();
		this.bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	
	/*
	 * @desc ƴװ��Ӧ��Ϣ��
	 * @params String info ��Ӧ��Ϣ�ַ�������
	 * @returns Response ������Ӧ��Ϣ��������������ʽ���������Ӧ��Ϣ
	 * */
	public Response print(String info){
		this.content.append(info).append(this.CRLF);
		this.len+=(info+this.CRLF).getBytes().length;
		return this;
	}
	
	/*
	 * @descƴװ��Ӧ��Ϣͷ���У�˽�з������ڲ�ʹ��
	 * @params code Ӧ����
	 * */
	private void createHeadInfo(int code){
		headInfo.append("HTTP/1.1").append(this.BLANK).append(code).append(this.BLANK);
		switch(code){
		case 200:
			headInfo.append("OK");
			break;
		case 404:
			headInfo.append("Not Found");
			break;
		case 500:
			headInfo.append("Server Error");
		}
		headInfo.append(this.CRLF);
		//��Ӧͷ
		headInfo.append("Server:BWS/1.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Content-Type:text/html;charset=GBK").append(CRLF);
		//���ĳ���--�ֽ���
		headInfo.append("Content-Length:").append(Integer.toString(len)).append(CRLF);
		
		headInfo.append(CRLF);//��һ�У���ʼ����
	}
	
	/*
	 * @desc ������Ϣ���ͻ���
	 * @params int code ״̬�룬�ڵ��ø÷���ʱ����
	 * */
	void pushToClient(int code){
		this.createHeadInfo(code);
		this.print("");
		
		try {
			bw.append(this.headInfo.toString());
			bw.append(this.content.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		CloseUtil.closeAll(bw);
	}
}
