<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>修改用户信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
        .divForm{
            position: absolute;/*绝对定位*/
            width: 300px;
            height: 200px;
            /*border: 1px solid red;*/
            /*background-color: deepskyblue;*/
            /*text-align: center;!*(让div中的内容居中)*!*/
            top: 50%;
            left: 50%;
            margin-top: -200px;
            margin-left: -150px;
        }
        label{
            height:50px;
            line-height:50px;
            margin-bottom:20px;
        }
    </style>
</head>
<body>
<!-- 引入导航栏页面 -->
<%@include file="adminHeader.jsp"%>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改用户信息</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="divForm">
        <form action="${pageContext.request.contextPath}/userUpdate" method="post">
            <%-- 运行失败检查语句 --%>
            <%-- 隐藏域 --%>
            <input type="hidden" name="userID" value="${queryUser.userID}">

            <div class="form-group">
                <label>用户名称</label>
                <input type="text"  name="userName" class="form-control" value="${queryUser.userName}" required>
            </div>
            <div class="form-group">
                <label>用户密码</label>
                <input type="text" name="userPwd" class="form-control" value="${queryUser.userPwd}" required>
            </div>
            <div class="form-group">
                <label>用户权限</label>
                <input type="text" name="userRoot" class="form-control" value="${queryUser.userRoot}" required>
            </div>

            <button type="submit" class="btn btn-default">修改用户信息</button>
        </form>
    </div>

</div>
