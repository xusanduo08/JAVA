package com.mengfansheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SortInnerType {

	public static void main(String[] args){
		String[] arr = {"a", "abc", "bcf", "ace"};
		
		sort(arr);
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("abc");
		list.add("bcf");
		list.add("ace");
		sort(list);
		
	}
	
	public static <T extends Comparable<T>> void sort(List<T> list){ //�������أ����Զ�List��������
		Object[] arr = list.toArray();
		boolean sorted = true;
		int len = arr.length;
		for(int j = 0; j < len; j++){
			sorted = true;
			for(int i = 0; i< len - 1 - j; i++){
				if(((Comparable)arr[i]).compareTo(arr[i+1])>0){ //����Comparable�ӿ��е�CompareTo����
					Object temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false;
				}
			}
			if(sorted){
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * �������Զ�Integer/Character/String/Date��ʵ��Comparable�ӿڵ��������������
	 * */
	
	public static <T extends Comparable<T>> void sort(T[] arr){  //ʹ�÷���
		boolean sorted = true;
		int len = arr.length;
		for(int j = 0; j < len; j++){
			sorted = true;  	//���ٱȽϵ�����
			for(int i = 0; i< len - 1 - j; i++){ 	//����ÿ�˱Ƚϴ���
				if(((Comparable)arr[i]).compareTo(arr[i+1])>0){
					T temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false;
				}
			}
			if(sorted){
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
}
