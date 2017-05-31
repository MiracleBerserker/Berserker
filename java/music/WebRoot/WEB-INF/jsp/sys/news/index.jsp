<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
pageContext.setAttribute("basePath",request.getContextPath()+"/");
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${basePath}css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}css/style.css" />
    <script type="text/javascript" src="${basePath}js/jquery.js"></script>
    <script type="text/javascript" src="${basePath}js/bootstrap.js"></script>
    <script type="text/javascript" src="${basePath}js/ckform.js"></script>
    <script type="text/javascript" src="${basePath}js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
		 table { border:solid 1px #000000; table-layout:fixed;}
		 td { white-space:nowrap; overflow:hidden; text-overflow:ellipsis;}
 


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="index.html" method="get">  
    资讯名称：
    <input type="text" name="rolename" id="rolename"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增资讯</button>
</form>
<table class="table table-bordered table-hover definewidth m10" width="200">
    <thead>
    <tr>
        <th>资讯名称</th>
        <th>发表时间</th>
        <th>作者</th>
		<th>内容</th>
        <th>管理操作</th>
    </tr>
    </thead>
      <c:choose>
        <c:when test="${newses!=null}">
          <c:forEach items="${newses}" var="nw" varStatus="vs">
           <tr>
            <td>${nw.newsTitle}</td>
            <td>${nw.newsTime}</td>
            <td>${nw.newsFrom}</td>
			<td>
			${nw.newsContent}
			</td>
            <td>
                  <a href="editUI.action?id=${nw.newsId}">编辑</a>
            </td>
        </tr>
          </c:forEach>
        </c:when>
      <c:otherwise>
      <tr>
        <td colspan="5">暂时没有数据!!!!</td>
      </tr>
      </c:otherwise>
      </c:choose>   
        
</table>
</body>
<script>
    $(function () {
        
		$('#addnew').click(function(){

				window.location.href="add.html";
		 });
    });

	function del(id)
	{
		if(confirm("确定要删除吗？"))
		{
			var url = "index.html";
			window.location.href=url;		
		
		}
	}
</script>
</html>
