package com.mengfansheng.javaload;

import java.util.Arrays;

/**
 * ѡ������
 * ��һ��ѡ���0С�ķŴ�a[0]λ��
 * �ڶ���ѡ���1С�ķŵ�a[1]λ��
 * ...
 * ��N��ѡ���NС�ķŵ�a[N]λ��
 * **/
public class selectSort {

	public static void main(String[] args){
		int a[] = {3,2,4,7,5,1};
		int b[] = select(a.length, a);
		System.out.println(Arrays.toString(b));
	}
	
	public static int[] select(int size, int[] a){
		for(int i = 0; i < size - 1; i++){
			int tempMin = i;
			for(int j = i+1; j < size; j++){
				if(a[j] < a [tempMin]){
					tempMin = j;
				}
			}
			int temp = a[i];
			a[i] = a[tempMin];
			a[tempMin] = temp;
		}
		return a;
	}
	
}
