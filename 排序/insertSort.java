package com.mengfansheng.javaload;

import java.util.Arrays;

/**
 * �����Ϊ���򲿷ֺ����򲿷֣����򲿷��������򲿷�����
 * һ��ʼ�����򲿷�ֻ��a[0]��ʣ�µĶ������򲿷�
 * �������򲿷֣����뵽���򲿷ֺ��ʵ�λ��
 * */
public class insertSort {

	public static void main(String[] args){
		int a[] = {3,2,4,7,5,1};
		int b[] = insert(a.length, a);
		System.out.println(Arrays.toString(b));
		String str;
	}
	
	public static int[] insert(int size, int[] a){
		for(int i = 1; i < size; i++){
			for(int j = 0; j < i; j++){
				if(a[i] < a[j]){
					int temp = a[i];
					for(int k = i; k>j; k--){//��j������j��λ�õ�i������i��λ�õ�����������һλ
						a[k] = a[k - 1];
					}
					a[j] = temp;
					break;
				}
			}
		}
		return a;
		
	}
	
}
