package com.mengfansheng.net;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
/**
 * ����ͨ�������url���ض�Ӧ����Ӧ��Ϣ
 * **/
public class WebApp {
	private static ServletContext context;
	//��̬����飬ֻ�ڹ��캯��ǰִ��һ�Σ�ִֻ��һ��
	static {
		
		WebHandler web = new WebHandler();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser sax = factory.newSAXParser();
			
			sax.parse(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("com/mengfansheng/net/web.xml"), web);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		context = new ServletContext();
		
		Map<String, String> mapping = context.getMapping();
		//mapping.put("/login", "login");
		for(Mapping map:web.getMappingList()){
			List<String> urls = map.getUrlPattern();
			for(String url:urls){
				mapping.put(url, map.getName());
			}
		}
		
		Map<String, String> servlet = context.getServlet();
		//servlet.put("login", "com.mengfansheng.net.LoginServlet");
		for(Entity entity:web.getEntityList()){
			servlet.put(entity.getName(), entity.getClz());
		}
		
		
	}
	
	/**
	 * @desc ͨ��url���ض�Ӧ����Ӧ��Ϣ
	 * @param String url �����url
	 * @return Servlet ��Ӧ��Ϣ����
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * **/
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if(null == url || (url = url.trim()).equals("")){
			return null;
		}
		//�����ַ�����������ʹ��ʱ�������󣬷���
		String name = context.getServlet().get(context.getMapping().get(url));
		
		return (Servlet) Class.forName(name).newInstance();
	}
}
