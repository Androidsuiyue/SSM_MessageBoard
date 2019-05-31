<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/commons/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"	import="java.util.* " %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户登录</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../../images/head.png">
    <link href="${cp}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${cp}/css/font-awesome.css" rel="stylesheet">
    <link href="${cp}/css/style.css" rel="stylesheet">

    <script src="${cp}/js/jquery-3.2.1.min.js"></script>
    <script src="${cp}/js/bootstrap.min.js"></script></head>
<body class="gray-bg">
<!--导航栏部分-->
<jsp:include page="include/header.jsp"/>
<%--<form action="/backend/login" method="post" align="center">--%>
    <%--用户名：<input type="text"  name="account"/><br>--%>
    <%--密码：   <input type="password"   name="password"/><br>--%>
    <%--<input type="submit"  value="登录"/>--%>
<%--</form>--%>
<div class="middle-box text-center loginscreen">
    <div style="padding: 100px 0px;">
        <div>
            <h1 class="logo-name">GS</h1>
        </div>
        <h3>欢迎使用 Guns</h3>
        <br/>
        <c:if test="${registerError!=null }">
                <h4 style="color: red;">${registerError}</h4>
        </c:if>

        <form class="m-t" role="form" action="/backend/doRegister" method="post">
            <div class="form-group">
                <input type="text" name="usernumber" class="form-control" placeholder="学工号" required="">
            </div>
            <div class="form-group">
                <input type="text" name="name" class="form-control" placeholder="姓名" required="">
            </div>

            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="密码" required="">
            </div>
            <div class="form-group">
                <input type="text" name="email" class="form-control" placeholder="邮箱" required="">
            </div>
            <div class="form-group">
                <input type="text" name="tel" class="form-control" placeholder="电话" required="">
            </div>
            <%--<div class="form-group" style="float: left;">--%>
                <%--<div class="col-sm-8" style="padding-left: 0px; padding-right: 0px;">--%>
                    <%--<input class="form-control" type="text" name="kaptcha" placeholder="验证码" required="">--%>
                <%--</div>--%>
                <%--<div class="col-sm-4" style="padding-left: 0px; padding-right: 0px;">--%>
                    <%--<img src="${ctxPath}/kaptcha" id="kaptcha" width="100%" height="100%"/>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-group" style="float: left;">--%>
                <%--<div class="checkbox" style="text-align: left">--%>
                    <%--<label>--%>
                        <%--<input type="checkbox" name="remember" style="margin-top: 2px;">记住我--%>
                    <%--</label>--%>
                <%--</div>--%>
            <%--</div>--%>
            <input type="submit" class="btn btn-primary block full-width m-b" value="注 册"/>
            </p>
        </form>
    </div>
    <!--尾部-->
    <jsp:include page="include/foot.jsp"/>
    <script type="text/javascript">
        function startRegister() {
            var loading = layer.load(0);
            var user = {};
            user.usernumber = document.getElementsByName("usernumber").value;
            user.name = document.getElementsByName("name").value;
            user.password = document.getElementsByName("password").value;
            user.email = document.getElementsByName("email").value;
            user.tel = document.getElementsByName("tel").value;
            if(user.usernumber == ''){
                layer.msg('学工号不能为空',{icon:2});
                return;
            }
            else if(user.usernumber.length >= 12){
                layer.msg('学工号长度不能超过12个字符',{icon:2});
                return;
            }
            if(user.name == ''){
                layer.msg('姓名不能为空',{icon:2});
                return;
            }
            else if(user.name.length >= 15){
                layer.msg('姓名长度不能超过15个字符',{icon:2});
                return;
            }
            else if(user.password == ''){
                layer.msg('密码不能为空',{icon:2});
                return;
            }
            else if(user.password.length>= 20){
                layer.msg('密码长度不能超过20个字符',{icon:2});
                return;
            }
            var registerResult = null;
            $.ajax({
                async : false, //设置同步
                type : 'POST',
                url : '${cp}/doRegister',
                data : user,
                dataType : 'json',
                success : function(result) {
                    registerResult = result.result;
                },
                error : function(result) {
                    layer.alert('查询用户错误');
                }
            });
            if(registerResult == 'success'){
                layer.close(loading);
                layer.msg('注册成功',{icon:1});
                window.location.href="${cp}/login";
            }
            else if(registerResult == 'usernumberExist'){
                layer.close(loading);
                layer.msg('这个用户名已经被占用啦！',{icon:2});
            }
            else if(registerResult == 'fail'){
                layer.close(loading);
                layer.msg('服务器异常',{icon:2});
            }
        }
    </script>

</div>
</body>
</html>