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
    <link href="${cp}/css/style_1.css" rel="stylesheet">


    <script src="${cp}/js/jquery-3.2.1.min.js"></script>
    <script src="${cp}/js/bootstrap.min.js"></script></head>
<body class="gray-bg">
<!--导航栏部分-->
<jsp:include page="include/header.jsp"/>
<div class="middle-box text-center loginscreen">
    <div style="padding: 50px 0px;">
        <div>
            <h1 class="logo-name">Qzh</h1>
        </div>
        <h3>欢迎使用</h3>
        <br/>
        <c:if test="${loginError!=null }">
                <h4 style="color: red;">密码错误</h4>
        </c:if>

        <form class="m-t" role="form" action="/backend/doLogin" method="post">
            <div class="form-group">
                <input type="text" name="username" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="密码" required="">
            </div>
            <div class="form-group" style="float: left;">
                <div class="checkbox" style="text-align: left">
                    <label>
                        <input type="checkbox" name="remember" style="margin-top: 2px;">记住我
                    </label>
                </div>
            </div>
            <input type="submit" class="btn btn-primary block full-width m-b"  value="登 录"/>
            </p>
        </form>
    </div>
    <!--尾部-->
    <jsp:include page="include/foot.jsp"/>

</div>
</body>
</html>