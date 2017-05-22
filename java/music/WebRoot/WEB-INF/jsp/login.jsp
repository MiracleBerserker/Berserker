<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
 pageContext.setAttribute("basePath",request.getContextPath()+"/");
%>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理系统</title>
	<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${basePath}css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}css/style.css" />
    <script type="text/javascript" src="${basePath}js/jquery.js"></script>
    <script type="text/javascript" src="${basePath}js/bootstrap.js"></script>
    <script type="text/javascript" src="${basePath}js/ckform.js"></script>
    <script type="text/javascript" src="${basePath}js/common.js"></script>
    <script type="text/javascript">
    	$(function() {
    		var username =null;
    		if (username == undefined) {
    			
    		} else {
    			$("#username").val(username);
    		}
    		$("#randomcode").click(function() {
    			$(this).attr("src","randomcode.do?"+Math.random());
    		});
    		$("#verify").keyup(function() { //用户在输入验证码就进行ajax异步请求
    			var ucode = $(this).val();
    			$("#res").empty();
    			$.get("randomcodeajax.do",{"v":"isRandomCodeAjax","ucode":ucode},function(data){
    				$("#res").append($(data)); //将服务器端返回的html追加span标签内
    			},"html");
    		});
    	});
    </script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>  
</head>
<body>
<div class="container">

    <form class="form-signin" method="post" action="login.do">
        <h2 class="form-signin-heading">登录系统</h2>
        
        账号：<input type="text" name="username" class="input-block-level" placeholder="账号" id="username"><br/>
        密码：<input type="password" name="password" class="input-block-level" placeholder="密码">

        <p><button class="btn btn-large btn-primary" type="submit">登录</button></p>
    </form>

</div>
</body>
</html>