package com.mengfansheng.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����Statement��ʹ�ã��Լ����������״�����sqlע������
 * **/

public class JDBC02 {

	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root", "");
			
			Statement stmt = conn.createStatement();//ִ��sql��䣬��������ؽ��
			//String sql = "insert into user(id, name, age,work) values (null, 'mengfansheng', 25, 'IT')";
			//stmt.execute(sql);
			
			//ģ��SQLע��
			String id = "5 or 1=1";//��ʱ��������������¼��where����ó��Ķ���true�����м�¼���ᱻɾ���������sqlע��
			String sql = "delete from user where id=" + id;//��ִ�е�sql�����ͨ���ַ���ƴ�ӵķ�ʽ�����ģ����ַ�ʽ�����ײ���sqlע��
			stmt.execute(sql);
			
			/**
			 * statement �ڹ����в������ã���Ϊ��sqlע������
			 * �Ƚϳ��õ���prepareStatement
			 * **/
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
