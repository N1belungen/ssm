<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>注册</title>
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
  </style>

</head>

<body>
<div class="divForm">
  <form action="${pageContext.request.contextPath}/register/registerUser" method="post" onsubmit="return judgeusername()">
    <div class="title" align="center">注 册</div>

    <div class="form-group has-success has-feedback">
      <label class="control-label">用户名</label>
      <input type="text" name="userName" id="userName" class="form-control" autocomplete="off" placeholder="请设置用户名" onblur="judgeusername()">
      <span class="help-block" id="userNameInfo"></span>
    </div>

    <div class="form-group has-error has-feedback">
      <label class="control-label">密码</label>
      <input type="password" name="userPwd" class="form-control" autocomplete="off" placeholder="请设置密码">
      <span class="help-block"></span>
    </div>

    <div align="center">
      <button type="submit" class="btn btn-primary">注册</button>
    </div>
  </form>
</div>

<script src = "${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
<script>
  function judgeusername(){
    var flag = "false";

    // 获取输入框中对应的值 并去掉字符串两端空格
    var userName = document.getElementById("userName").value;
    userName = userName.trim();

    //用户名为空 提示信息
    if(userName == ""){
      document.getElementById("userNameInfo").innerHTML = "用户名不能为空!";
    }
    //用户名不规范 提示信息
    else if (userName.length < 6 || userName.length > 16){
      document.getElementById("userNameInfo").innerHTML = "用户名的长度为6-16位!";
    }
    else{
      document.getElementById("userNameInfo").innerHTML = "";

    //ajax验证
      $.ajax({
        url:"${pageContext.request.contextPath}/register/judgeRegister",
        type:"post",
        data:{"userName":userName},//json数据格式的用户名从jsp传递给controller var regUsername => "regUsername"
        dataType:"json",
        async:false,//让ajax执行代码顺序同步
        success(data){
          if(data.msg == "false"){
            document.getElementById("userNameInfo").innerHTML = "用户名已存在";
          }
          else{
            document.getElementById("userNameInfo").innerHTML = "";
            flag = true;
          }
        }
      });
    }
    return flag;
  }
</script>



</body>
</html>
