<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
pageContext.setAttribute("basePath",request.getContextPath()+"/");
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>自动刷新测试</title>
  </head>
  
  <body>
  
    <form id="form1" ></form>
    <input type="text" form="form1"/>
    <button form="form1" type="submit" formaction="refresh.action" formmethod="get" style="width:70px;height:30px;"></button>
   
  </body>
</html>
