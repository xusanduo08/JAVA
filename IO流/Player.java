package com.mengfansheng.Thread;

/*
 * ������
 * */

public class Player implements Runnable {
	private Movie m;
	public static void main(String[] args) {

	}
	
	public Player(Movie m) {
		super();
		this.m = m;
	}

	public void run(){
		for(int i = 0; i< 20; i++){
			if(0 == i%20){
				m.play("������");
			} else {
				m.play("�Ұ׻�");
			}
		}
	}

}
