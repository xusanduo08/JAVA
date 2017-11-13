package com.mengfansheng.net;

import java.util.Map;
/**
 * ����ͨ�������url���ض�Ӧ����Ӧ��Ϣ
 * **/
public class WebApp {
	private static ServletContext context;
	//��̬����飬ֻ�ڹ��캯��ǰִ��һ�Σ�ִֻ��һ��
	static {
		context = new ServletContext();
		
		Map<String, String> mapping = context.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		Map<String, String> servlet = context.getServlet();
		servlet.put("login", "com.mengfansheng.net.LoginServlet");
		servlet.put("register", "com.mengfansheng.net.RegisterServlet");
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
