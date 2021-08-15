<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借阅书籍</title>
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
                    <small>借阅书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <form action="${pageContext.request.contextPath}/book/bookNameQuery" method="post" class="form-inline" style="float: right">
            <div class="form-group">
                <input type="text" name="bookName" class="form-control"  placeholder="请输入要借阅的书籍名称">
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
                    <th>书籍总数量</th>
                    <th>已借阅数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
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
                        <td>
                            <a id="btn" type="button" class="btn btn-primary"  onclick="toBorrow(${book.bookID},'${sessionScope.userName}')" data-toggle="modal" data-target="#borrowBookModal">借阅</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <!-- 模态框（Modal） -->
            <div class="modal fade" id="borrowBookModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">借阅信息</h4>
                        </div>

                        <div class="modal-body">
                            <form action="${pageContext.request.contextPath}/book/bookBorrowAdd" method="post">

                                <div class="form-group">
                                    <label for="userName" class="control-label">借阅账户:</label>
                                    <input type="text" class="form-control" id="userName" name="userName" readonly="readonly">
                                </div>

                                <div class="form-group">
                                    <label for="bookName" class="control-label">借阅书籍:</label>
                                    <input type="text" class="form-control" id="bookName" name="bookName"  readonly="readonly">
                                </div>

                                <div class="form-group">
                                    <label for="dayMount" class="control-label">借阅天数:</label>
                                    <select class="form-control" id="dayMount" name="dayMount" onblur="time()">
                                        <option value="0">请选择借阅的天数</option>
                                        <option value="5">5天</option>
                                        <option value="10">10天</option>
                                        <option value="15">15天</option>
                                        <option value="20">20天</option>
                                        <option value="30">30天</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="borrowTime" class="control-label">借阅时间:</label> <input
                                        type="text" class="form-control"
                                        id="borrowTime" name="borrowTime" readonly="readonly">
                                </div>

                                <div class="form-group" id="returnTime">
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-primary">确认借阅</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div><!-- Modal -->

        </div>
    </div>
</div>

<script type="text/javascript">
    function toBorrow(bookID , userName){
        $.ajax({
            url:"${pageContext.request.contextPath}/book/toBookBorrow",
            type:"post",
            dataType:"json",
            data:{bookID : bookID , userName : userName},
            async:false,//让ajax执行代码顺序同步

            success(data){
                $("#userName").val(data.userName);
                $("#bookName").val(data.bookName);
                $("#borrowTime").val(data.borrowTime);
            }
        });
    }

    function time(){
        $.ajax({
            url:"${pageContext.request.contextPath}/book/bookBorrowTime",
            data:{dayMount:$("#dayMount").val()},
            success:function (returnTime) {
                var html="";
                html+="还书时间：<input\n" +
                    "type=\"text\" class=\"form-control\"\n" +
                    "id=\"returnTime\" name=\"returnTime\"  readonly=\"readonly\" value=\""+returnTime+"\">"
                $("#returnTime").html(html);
            },
        })
    }
</script>

</body>
</html>