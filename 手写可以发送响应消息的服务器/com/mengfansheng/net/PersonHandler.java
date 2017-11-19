package com.mengfansheng.net;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * person.xml�Ĵ�����
 * **/
public class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag;
	
	

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		persons = new ArrayList<Person>();//��ʼ�����ĵ�����ʱ���ʼ�� persons ����
	}

	//��ʼ����һ��Ԫ�أ���ʱ�пղ���¼Ԫ�ر�ǩ��������ʼ��������
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(null != qName){
			tag = qName;
		}
		if(null != qName && qName.equals("person")){
			person = new Person();
		}
	}

	//��ȡԪ��ֵ�������ݱ�ǩ�����óɶ����Ӧ���Ե�ֵ
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String str = new String(ch, start, length);
		if(null != tag && tag.equals("name")){
			person.setName(str);
		} else if(null != tag && tag.equals("age")){
			Integer age = Integer.valueOf(str);
			person.setAge(age);
		}
	}
	
	//Ԫ�ؽ���������
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if(qName.equals("person")){
			this.persons.add(person);
		}
		tag = null;
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("�����ĵ�����");
		
	}
	

}
