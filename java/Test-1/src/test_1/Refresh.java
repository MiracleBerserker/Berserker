package test_1;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Refresh extends HttpServlet{
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  ServletInputStream sis= req.getInputStream();
		  int len=-1;
		  byte []buff=new byte[1024];
		  while((len=sis.read(buff))!=-1){
			  System.out.println(new String(buff,0,len,"utf-8"));
		  }
		  
		  resp.getWriter().write("who is my lover");
		  System.out.println("charset:   "+req.getCharacterEncoding());
		  System.out.println("contextpath:   "+req.getContextPath());
		  System.out.println("contenttype:   "+req.getContentType());
		  System.out.println("localaddr:   "+req.getLocalAddr());
		  System.out.println("localname:   "+req.getLocalName());
		  System.out.println("localport:   "+req.getLocalPort());
		  System.out.println("local:   "+req.getLocale());
		  System.out.println("locals:   "+req.getLocales());
		  System.out.println("用户ip:   "+req.getRemoteAddr());
		  System.out.println("uri:   "+req.getRequestURI());
		  System.out.println("url:   "+req.getRequestURL());
		  System.out.println("method:   "+req.getMethod());
		  Enumeration<String> en= req.getHeaderNames();
		  String headName="";
		  //遍历请求头
		  System.out.println("=====================请求头遍历=========================");
		  while(en.hasMoreElements()){
			  headName=en.nextElement();
			  System.out.println(headName+":   "+req.getHeader(headName));
		  }
		  resp.setStatus(302);
		  resp.setHeader("refresh", "5;URL="+req.getContextPath()+"/index.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		  ServletInputStream sis= req.getInputStream();
		  int len=-1;
		  byte []buff=new byte[1024];
		  while((len=sis.read(buff))!=-1){
			  System.out.println(new String(buff,0,len,"utf-8"));
		  }
		  
		  resp.getWriter().write(new String("老时采菊东篱下".getBytes("utf-8"),"iso-8859-1"));
		  
	}
	
}
