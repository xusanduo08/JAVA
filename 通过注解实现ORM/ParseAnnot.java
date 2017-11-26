package com.mengfansheng.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ʹ�÷����ȡע����Ϣ��ģ�⴦��ע����Ϣ������
 * @author mengfansheng
 * **/
public class ParseAnnot {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		try {
			Class clz = Class.forName("com.mengfansheng.annotation.Student");
			
			//����������ע��
			Annotation[] annots = clz.getDeclaredAnnotations();
			for(Annotation a : annots){
				System.out.println(a);
			}
			//���ָ��ע������ĳ�����е�ע��(Ҳ����˵�ǻ�����ָ����ע��)
			Table st = (Table)clz.getAnnotation(Table.class);
			System.out.println(st.value());
			
			//���������Ե�ע��
			Field f = clz.getDeclaredField("name");//��ͨ��������ĳ������
			TableField tb = f.getAnnotation(TableField.class);//Ȼ����������Ե�ָ�����ע��
			//�������ܻ��ָ�����������ݿ��ж�Ӧ���ֶ����ơ������Լ��ֶγ���
			System.out.println(tb.columnName() +"--"+tb.type() +"--"+tb.length());
			
			//�������Ϳ��Ը��ݻ�õı������ֶε���Ϣ��ƴ�ӳ�DDL��䣬Ȼ��ʹ��JDBCִ�����SQL�������ݿ���������صı�
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
