package com.mengfansheng.Thread;

/*
 * 1����ʵ��ɫ
 * 2�������ɫ
 * 3�������ɫ�к�����ʵ��ɫ������
 * */

public class StaticProxy {

	public static void main(String[] args) {
		//������ʵ��ɫ
		You you = new You();
		
		//���������ɫ
		WeddingCompany we = new WeddingCompany(you);
		//ִ������
		we.marry();
	}

}

interface Marry{
	void marry();
}

class You implements Marry{

	@Override
	public void marry() {
		System.out.println("���϶���");
	}
	
}

//�����ɫ
class WeddingCompany implements Marry{

	private Marry you; //������ʵ��ɫ������
	
	public WeddingCompany() {
		super();
	}

	public WeddingCompany(Marry you) {
		super();
		this.you = you;
	}

	private void before(){
		System.out.println("��������");
	}
	private void after(){
		System.out.println("�붴��");
	}

	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}
