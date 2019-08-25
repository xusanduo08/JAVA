package com.mengfansheng.Thread;

/*
 * ������������ģʽ  �źŵƷ�
 * wait():�ȴ��� �ͷ���  sleep(): ���ͷ���
 * notify()/notifyAll():����
 * */
public class Movie {

	private boolean flag = true;
	/*
	 * flag == true =>�����������������ߵȴ���������ɺ�֪ͨ����������
	 * flag == false =>���������ѣ������ߵȴ���������ɺ�֪ͨ����������
	 * */

	private String pic;
	
	public synchronized void play(String pic){
		
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//ģ������
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�������
		this.pic = pic;
		//֪ͨ����
		this.notify();
		//������ͣ��
		this.flag = false;
	}
	
	public synchronized void watch(){
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//ģ������
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�������
		System.out.println(pic);
		//֪ͨ����
		this.notify();
		//������ͣ��
		this.flag = true;
	}
}
