<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>

    <style type="text/css">
        .divForm{
            position: absolute;/*绝对定位*/
            width: 360px;
            height: 200px;
            /*border: 1px solid red;*/
            /*background-color: deepskyblue;*/
            /*text-align: center;!*(让div中的内容居中)*!*/
            top: 50%;
            left: 50%;
            margin-top: -200px;
            margin-left: -150px;
        }
    </style>
</head>
<body>
<!-- 引入导航栏页面 -->
<%@include file="header.jsp"%>

<div class="divForm">
    <form method="post" action="${pageContext.request.contextPath}/toUserPwdUpdate" onsubmit="return judgeusernewpwd()">
        <div class="form-group has-success has-feedback">
            <label class="control-label">原密码</label>
            <input type="password" class="form-control" name="userPwd" id="userPwd" autocomplete="off" placeholder="请输入原密码">
        </div>

        <div class="form-group has-success has-feedback">
            <label class="control-label">新密码</label>
            <input type="password" class="form-control" name="userNewPwd" id="userNewPwd" autocomplete="off" placeholder="请输入新密码">
        </div>

        <div class="form-group has-success has-feedback">
            <label class="control-label">确认新密码</label>
            <input type="password" class="form-control" name="userNewPwd2" id="userNewPwd2" autocomplete="off" placeholder="请再次输入新密码" onblur="judgeusernewpwd()">
        </div>

        <span class="help-block" id="userPwdInfo"></span>
        <div align="center">
            <button type="submit" class="btn btn-primary">修改密码</button>
        </div>
    </form>
</div>


<script>
    function judgeusernewpwd(){
        var flag = "false";

        // 获取输入框中对应的值
        var userNewPwd = document.getElementById("userNewPwd").value;
        var userNewPwd2 = document.getElementById("userNewPwd2").value;

        //两次密码不一致 提示信息
        if(userNewPwd != userNewPwd2){
            document.getElementById("userPwdInfo").innerHTML = "两次输入的密码不一致!";
        }

        else{
            document.getElementById("userNameInfo").innerHTML = "";
            flag = true;
        }
        return flag;
    }
</script>

</body>
</html>
