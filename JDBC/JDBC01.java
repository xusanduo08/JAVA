package com.mengfansheng.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * JDBC���Ӳ���
 * **/
public class JDBC01 {

	public static void main(String[] args){
		//����������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			long start = System.currentTimeMillis();
			//�������ӣ����Ӷ����ڲ���ʵ������Socket������һ��Զ�̵����ӡ��ȽϺ�ʱ������Connection��������һ��Ҫ�㣡��
			//���������У�Ϊ�����Ч�ʣ�����ʹ�����ӳ����������Ӷ���
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			System.out.println(conn);
			long end = System.currentTimeMillis();
			//�������ӱȽϺ�ʱ
			System.out.println("�������ӣ���ʱ��" + (end - start) + "����");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
