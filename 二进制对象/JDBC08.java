package com.mengfansheng.JDBC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * ����BLOB��ʹ�ã�������
 * BLOB�������ݿ�
 * BLOB�����ݿ���ȡ��
 * **/
public class JDBC08 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");
			
			//�洢BLOB����
			ps = conn.prepareStatement("insert into user (name, img) values (?, ?)");
			ps.setString(1, "����");
			ps.setBlob(2, new FileInputStream("D:/qycache/picture/1.jpg"));
			ps.execute();
			
			//��ȡBLOB����
			ps1 = conn.prepareStatement("select * from user where id= ?");
			ps1.setInt(1, 22923);
			
			rs = ps1.executeQuery();
			while(rs.next()){
				Blob b = rs.getBlob("img");
				is = b.getBinaryStream();
				//����ȡ������������ļ�
				os = new FileOutputStream("d:/a.jpg");
				int temp = 0;
				while((temp = is.read()) != -1){
					os.write(temp);
				}
				
			}
			
		} catch(Exception e){
			e.printStackTrace();
			
		} finally {
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
