<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>

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

<body onload="userInfo('${sessionScope.userName}')">
<!-- 引入导航栏页面 -->
<%@include file="header.jsp"%>


<div class="divForm">
    <form>
        <label name="userID" for="userID">用户ID</label>
        <input id="userID" class="form-control" type="text" readonly>

        <label name="userName" for="userName">用户名</label>
        <input id="userName" class="form-control" type="text" readonly>

        <label name="userRoot" for="userRoot">用户权限</label>
        <input id="userRoot" class="form-control" type="text" readonly>
    </form>
</div>

<script>
    function userInfo(userName) {
        $.ajax({
            url:"${pageContext.request.contextPath}/queryUserInfo",
            type:"post",
            dataType:"json",
            data:{userName : userName},
            async:false,//让ajax执行代码顺序同步

            success(data){
                $("#userID").val(data.userID);
                $("#userName").val(userName);
                $("#userRoot").val(data.userRoot);
            }
        });
    }
</script>


</body>
</html>
