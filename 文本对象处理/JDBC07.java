package com.mengfansheng.JDBC;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * �����ı������CLOB��ʹ��
 * **/
public class JDBC07 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");
			
			
			ps = conn.prepareStatement("insert into user(name, text) values(?, ?)");
			ps.setString(1, "�Ϸ�ʤ");
			ps.setClob(2, new FileReader(new File("D:/Git/LICENSE.txt")));//���ı�����ֱ�����뵽���ݿ���
			ps.execute();
		} catch(Exception e) {
			
		}

	}

}
