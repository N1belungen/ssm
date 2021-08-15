<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增书籍</title>
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
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="divForm">
        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
            <%-- 运行失败检查语句 --%>
            <%-- 隐藏域 --%>
            <input type="hidden" name="bookID" value="${queryBooks.bookID}">

            <div class="form-group">
                <label>书籍名称</label>
                <input type="text"  name="bookName" class="form-control" value="${queryBooks.bookName}" required>
            </div>
            <div class="form-group">
                <label>书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" value="${queryBooks.bookCounts}" required>
            </div>
            <div class="form-group">
                <label>书籍借阅数量</label>
                <input type="text" name="detail" class="form-control" value="${queryBooks.bookBorrow}" required>
            </div>
            <div class="form-group">
                <label>书籍描述</label>
                <input type="text" name="detail" class="form-control" value="${queryBooks.detail}" required>
            </div>

            <button type="submit" class="btn btn-default">修改书籍信息</button>
        </form>
    </div>

</div>
