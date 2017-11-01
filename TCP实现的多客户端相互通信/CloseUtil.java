package com.mengfansheng.net;

import java.io.Closeable;
import java.io.IOException;
/*
 * �رչ���
 * �����������йر�
 * */
public class CloseUtil {

	public static void closeAll(Closeable... io) {  //...�ɱ����
		for(Closeable temp:io){
			if(null != temp){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
