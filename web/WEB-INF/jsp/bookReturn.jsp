<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>归还书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
<!-- 引入导航栏页面 -->
<%@include file="header.jsp"%>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>归还书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>借阅人</th>
                    <th>借阅时间</th>
                    <th>还书时间</th>
                </tr>
                </thead>

                <%-- 书籍数据从数据库中读取    --%>
                <tbody>
                <c:forEach var="borrow" items="${bookList}">
                    <tr>
                        <td>${borrow.bookID}</td>
                        <td>${borrow.bookName}</td>
                        <td>${borrow.userName}</td>
                        <td>${borrow.borrowTime}</td>
                        <td>${borrow.returnTime}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/borrowDelete?id=${borrow.bookID}">归还</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>