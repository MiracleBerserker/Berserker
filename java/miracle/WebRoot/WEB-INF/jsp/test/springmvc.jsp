<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
pageContext.setAttribute("basePath",request.getContextPath()+"/");
%>

<!DOCTYPE HTML >
<html>
  <head>

    
    <title>springmvc</title>

  </head>
  
  <body>
      <span>测试路径:${basePath}</span>
      <span>测试数据:${message}</span>
  </body>
</html>
