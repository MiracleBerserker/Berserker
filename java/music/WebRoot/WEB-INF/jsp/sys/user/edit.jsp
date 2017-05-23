<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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


    </style>
</head>
<body>
<form action="{:U('User/edit')}" method="post" class="definewidth m20">
<input type="hidden" name="id" value="${user.userId}" />
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">登录名</td>
            <td><input type="text" name="username" value="${user.userName}"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="password" value="${user.userPwd}"/></td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="realname" value="${user.userRealname}"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="${user.userMail}"/></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
            	<input type="radio" name="status" ${user.userStatus==1?'checked':''}></input>启用
            	<input type="radio" name="status" ${user.userStatus==0?'checked':''}></input>禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft">角色</td>
            <td></td>
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
				window.history.back();
		 });

    });
</script>