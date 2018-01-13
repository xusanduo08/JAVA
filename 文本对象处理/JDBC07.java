package com.mengfansheng.JDBC;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Clob;

/**
 * �����ı������CLOB��ʹ��
 * ���ַ������ı��ļ��������ݿ��е�CLOB�ֶ�
 * ��CLOB�ֶ�ֵȡ����
 * **/
public class JDBC07 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");
			
			/*
				ps = conn.prepareStatement("insert into user(name, text) values(?, ?)");
				ps.setString(1, "�Ϸ�ʤ");
				ps.setClob(2, new FileReader(new File("D:/Git/LICENSE.txt")));//���ı�����ֱ�����뵽���ݿ���
				ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aabbbccc".getBytes()))));
				ps.execute();
			*/
			ps = conn.prepareStatement("select * from user where id= ?");
			ps.setObject(1, 22921);
			rs = ps.executeQuery();
			while(rs.next()){
				Clob c = (Clob) rs.getClob("text");
				Reader r = c.getCharacterStream();
				int temp = 0;
				while((temp = r.read()) != -1){
					System.out.println((char)temp);
				}
			}
		} catch(Exception e) {
			
		}

	}

}
