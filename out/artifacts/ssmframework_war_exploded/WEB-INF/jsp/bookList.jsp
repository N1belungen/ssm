<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询书籍</title>
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
                    <small>查询书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <form action="${pageContext.request.contextPath}/book/bookNameQuery" method="post" role="form" style="float: right">
            <div class="form-group">
                <label></label>
                <input type="text" name="bookName" class="form-control"  placeholder="请输入要查询的书籍名称" autocomplete="off">
            </div>
            <button type="submit" class="btn btn-primary">查询</button>
        </form>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍数量</th>
                    <th>书籍借阅数量</th>
                    <th>书籍详情</th>
                </tr>
                </thead>

                <%-- 书籍数据从数据库中读取    --%>
                <tbody>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.bookBorrow}</td>
                        <td>${book.detail}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>