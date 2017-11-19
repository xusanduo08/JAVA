package com.mengfansheng.annotation;

/**
 * ʹ��ע��ʵ��ORM(Object Relationship Mapping)
 * ���ݿ�ʹ�õ��������ϵ�ģ���д�����ʱ�����������ģ�������֮����Ҫ��һ��ӳ��
 * ʹ��ע�⽫��������ݹ�ϵ����ӳ�䣬ͨ�������������ע�⣬����SQL���
 * **/

@Table(value="tb_student") //ʹ��ע���ʾ���������ݿ��ж�Ӧ���ű�
public class Student {
	//ʹ��ע���ʾ�����Զ�Ӧ���ݿ��е���һ�С����ݳ����Լ���������
	@TableField(columnName = "id", length = 10, type = "int")
	private int id;
	@TableField(columnName = "name", length = 10, type = "varchar")
	private String name;
	@TableField(columnName = "age", length = 3, type = "int")
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
