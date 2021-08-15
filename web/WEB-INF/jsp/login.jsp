<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录界面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

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
      .title{
        width:100%;
        height:50px;
        font-size:38px;
        text-align:center;
        line-height:50px;
        margin-bottom:20px;
      }
    </style>

  </head>

  <body>
  <div class="divForm">
    <form method="post" action="${pageContext.request.contextPath}/login/judgeLogin">
      <div class="title" align="center">欢 迎 登 录</div>

      <div class="form-group has-success has-feedback">
        <label class="control-label">用户名</label>
        <input type="text" class="form-control" name="userName" id="userName" autocomplete="off" placeholder="请输入用户名">
      </div>

      <div class="form-group has-success has-feedback">
        <label class="control-label">密码</label>
        <input type="password" class="form-control" name="userPwd" id="userPwd" autocomplete="off" placeholder="请输入密码">
      </div>

      <div align="center">
        <button type="submit" class="btn btn-primary">登录</button>
      </div>

      <div><a onclick="jumpRegister()">注册账号</a></div>
    </form>
  </div>

  <script>
    function jumpRegister() {
      <%--window.open("${pageContext.request.contextPath}/register/index");--%>
      window.location = "${pageContext.request.contextPath}/register/index";
    }
  </script>

  </body>
</html>
