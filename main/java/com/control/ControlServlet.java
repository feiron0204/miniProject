package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("*.do")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private Map<String, Object> map = new HashMap<String, Object>();
	   
	   @Override
	   public void init(ServletConfig config) throws ServletException {
	      String propertyConfig = config.getInitParameter("propertyConfig");
	      System.out.println("propertyConfig = " + propertyConfig);
	      
	      //String realFolder = config.getServletContext().getRealPath("/WEB-INF");
	      //String realPath = realFolder + "/" + propertyConfig;
	      //System.out.println("realPath = " +realPath);
	      
	      FileInputStream fin = null;
	      Properties properties = new Properties();
	      
	      try {
	         fin = new FileInputStream(propertyConfig);
	         //fin = new FileInputStream(realPath);
	         
	         properties.load(fin);
	         System.out.println("properties = "+properties);
	         
	      } catch (IOException e) {
	         e.printStackTrace();
	      }finally{
	         try {
	            fin.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	      System.out.println();
	      
	      Iterator it = properties.keySet().iterator();
	      while(it.hasNext()) {
	         String key = (String)it.next();
	         System.out.println("key = "+key);
	         
	         String className = properties.getProperty(key);
	         System.out.println("className = "+className);
	         
	         try {
	            Class<?> classType = Class.forName(className);
	            Object ob = classType.newInstance();
	            
	            System.out.println("ob = "+ob);
	            
	            map.put(key, ob);
	            
	         } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	         } catch (InstantiationException e) {
	            e.printStackTrace();
	         } catch (IllegalAccessException e) {
	            e.printStackTrace();
	         } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	         } 
	         
	         System.out.println();
	      }//while
	   }//init
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get은 인코딩이 되서오는데 post일때는 한글처리가 필요함
		if(request.getMethod().equals("POST")) request.setCharacterEncoding("UTF-8");
	
		// http://localhost:8090/mvcMember/member/writeForm.do 여기서 뒤에만(/member/writeForm.do)필요함
		String category=request.getServletPath();
		System.out.println("category = "+category);// /member/writeForm.do
		//이제 이걸 이용해서 properties 한테 어디로가야하는지 물어보고 위치받을껴
		CommandProcess com = (CommandProcess)map.get(category); //member.service.WriteFormService
		
		
	      String view = null;
	      
	      try {
	         view = com.requestPro(request, response); // 자바 파일 메소드 요청"/member/writeForm.jsp"
	      } catch (Throwable e) {
	         e.printStackTrace();
	      }
	      
	      //forword
	      RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	      dispatcher.forward(request, response);
	}
	
}
