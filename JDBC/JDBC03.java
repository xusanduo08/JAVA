package com.mengfansheng.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ����PreparedStatement��ʹ�ã��Լ����sqlע��ķ�ֹ
 * **/
public class JDBC03 {

	public static void main(String[] args){
		
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");
		
			String sql = "insert into user(name, age, work) values (?, ? ,?)";//ʹ��ռλ��
			PreparedStatement ps = conn.prepareStatement(sql);
			//ʹ��setXXX()���������ֶ�ֵ����ط���������1��ʼ
			ps.setString(1, "�Ϸ�ʤ");
			ps.setInt(2, 27);
			ps.setString(3, "IT");
			ps.execute();
			
			//����ֱ����setObj()���������ֶ�ֵ
			ps.setObject(1, "fansheng");
			ps.setObject(2, 27);
			ps.setObject(3, "IT");
			ps.execute();
			
			//����sqlע������
			String deleSql = "delete from user where id = ?";
			PreparedStatement deletePs = conn.prepareStatement(deleSql);
			deletePs.setString(1, "1 or 2=2");//��ʱ��ʹ���������������Ҳ����ɾ����¼��preparedStatement�Դ�ִ�е�sql��һ��Ԥ����Ĺ���
			deletePs.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
