<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
pageContext.setAttribute("basePath", request.getContextPath()+"/");
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


    </style>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
<input type="hidden" name="id" value="" />
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="15%" class="tableleft">资讯名称</td>
        <td><input type="text" name="grouptitle" value="${news.newsTitle}"/></td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">资讯图片</td>
        <td><input type="file" name="grouptitle"/></td>
    </tr>
    <tr>
        <td class="tableleft">资讯作者</td>
        <td><input type="text" name="moduletitle" value="${news.newsFrom}"/></td>
    </tr>   
	<tr>
        <td class="tableleft">资讯来源</td>
        <td><input type="text" name="moduletitle"/></td>
    </tr>
	<tr>
        <td class="tableleft">资讯内容</td>
        <td><input type="text" name="moduletitle"/></td>
    </tr>
    <tr>
        <td class="tableleft">资讯类别</td>
        <td>
            <input type="radio" name="status" value="0" checked/> 内地
            <input type="radio" name="status" value="1"/> 港台
			<input type="radio" name="status" value="2"/> 日韩
			<input type="radio" name="status" value="3"/> 欧美
			<input type="radio" name="status" value="4"/> 独家 
			<input type="radio" name="status" value="5"/> 专题
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });

    });
</script>