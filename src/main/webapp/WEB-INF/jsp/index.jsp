<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.qzhenghao.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="utf-8">
    <title>这是个留言板</title>
    <link rel="stylesheet" type="text/css" href="${cp}/css/index.css" />
    <link href="${cp}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${cp}/css/style.css" rel="stylesheet">

    <script src="${cp}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${cp}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${cp}/js/layer.js" type="text/javascript"></script>
    <script type="text/javascript" src="${cp}/js/index.js"></script>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="container">
    <!--导航栏部分-->

    <div class="head">
                <%--<div id="tip" style="display: none;" class="form tip">欢迎进入留言板，<span class="user"><%=usernumber%></span></div>--%>
                <div class="btn-group">
                    <button class="btn-head" id="btn-look">查看留言</button>
                    <button class="btn-head" id="btn-send">发布留言</button>
                    <button class="btn-head" id="btn-make">修改留言</button>
                </div>
                               
                <%--<div id="tip" style="display: none;" class="form tip">欢迎进入留言板，<span class="user">--%>
                    <%--<a href="login.jsp">登 录</a></span><span>|</span></div>--%>
               <%----%>



            <%--<div id="form" action="#" class="form" method="post">--%>
            <%--用户名:--%>
            <%--<input type="text" name="username" size="10" />--%>
            <%--密码:--%>
            <%--<input type="password" name="password" size="10" />--%>
            <%--<input type="submit" name="btn" value="登 录" class="btn-login" />--%>
        <%--</div>--%>
       <%----%>
            <%--<h4 style="color: red;">密码错误</h4>--%>

        <%--<div id="tip" style="display: none;" class="form tip">欢迎进入留言板，<span class="user">${usernumber}</span></div>--%>
        <%--<div class="btn-group">--%>
            <%--<button class="btn-head" id="btn-look">查看留言</button>--%>
            <%--<button class="btn-head" id="btn-send">发布留言</button>--%>
            <%--<button class="btn-head" id="btn-make">修改留言</button>--%>
        <%--</div>--%>

    </div>
    <div class="content">
        <div class="left">
            <div class="left-title">
                <img src="../../images/msg_content.png" class="icon" />
                <span class="title">留言内容</span>
            </div>
            <ul class="list">
                <li class="list-li bg-hl">
                    <span class="li-text">小区噪音严重影响市民健康？</span>
                    <span class="tag-warm">未解决</span>
                    <span class="li-date">2019-03-18</span>
                </li>
                <li class="list-li">
                    <span class="li-text">出国需要办理什么手续？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li bg-hl">
                    <span class="li-text">谁能介绍下宁波的考研暑假强化班？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li">
                    <span class="li-text">考试分数线总分考但是公共课成绩低能上线吗？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li bg-hl">
                    <span class="li-text">出国需要办理什么手续吗？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li">
                    <span class="li-text">有没有人说过天才需要百分之九十九的运气？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li bg-hl">
                    <span class="li-text">谁能介绍下宁波的考研暑假强化班？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li">
                    <span class="li-text">考试分数线总分考但是公共课成绩低能上线吗？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li bg-hl">
                    <span class="li-text">出国需要办理什么手续吗？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li">
                    <span class="li-text">有没有人说过天才需要百分之九十九的运气？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li bg-hl">
                    <span class="li-text">谁能介绍下宁波的考研暑假强化班？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li">
                    <span class="li-text">考试分数线总分考但是公共课成绩低能上线吗？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li bg-hl">
                    <span class="li-text">出国需要办理什么手续吗？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li">
                    <span class="li-text">有没有人说过天才需要百分之九十九的运气？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
                <li class="list-li bg-hl">
                    <span class="li-text">出国需要办理什么手续吗？</span>
                    <span class="tag-success">已解决</span>
                    <span class="li-date">2019-03-28</span>
                </li>
            </ul>
            <div class="btn-group-foot">
                <button class="btn-foot">上一页</button>
                <button class="btn-foot">下一页</button>
                <button class="btn-foot">首 页</button>
            </div>
        </div>
        <div class="right">
            <div class="right-content">
                <div class="right-title">
                    <img src="../../images/msg_detail.png" class="icon" />
                    <span class="title" id="head-title">查看留言</span>
                </div>
                <table class="tb" id="tb">
                    <tr>
                        <td valign="top" class="tb-title">主题：</td>
                        <td valign="top" class="tb-content">小区噪音严重影响市民健康</td>
                    </tr>
                    <tr>
                        <td valign="top" class="tb-title">作者：</td>
                        <td valign="top" class="tb-content">小小</td>
                    </tr>
                    <tr>
                        <td valign="top" class="tb-title">日期：</td>
                        <td valign="top" class="tb-content">2019-03-18</td>
                    </tr>
                    <tr style="height: 50px;">
                        <td valign="top" class="tb-title">内容：</td>
                        <td valign="top" class="tb-content">小区噪音验证影响市民健康，很是让人烦躁，你们怎么看？</td>
                    </tr>
                    <tr id="tr-content" style="height: 50px;display: none;">
                        <td valign="top" class="tb-title">内容：</td>
                        <td valign="top" class="tb-content">
                            <textarea rows="5" cols="35">小区噪音验证影响市民健康，很是让人烦躁，你们怎么看？</textarea>
                        </td>
                    </tr>
                    <tr id="tb-content">
                        <td valign="top" class="tb-title">回复：</td>
                        <td valign="top" class="tb-content td-color">已经将您的咨询转到市长信箱处理，请您留意场相关信箱。</td>
                    </tr>
                </table>
                <div class="tb" style="display: none;" id="look-content">
                    <p class="tb-title">主题：</p>
                    <input type="text" name="text" size="40">
                    <p class="tb-title">内容：</p>
                    <textarea rows="6" cols="42"></textarea>
                    <input type="submit" name="btn" value="发 表" class="btn-login" />
                </div>
            </div>
        </div>
    </div>
    <div class="foot"></div>
    <!--尾部-->
    <jsp:include page="include/foot.jsp"/>

</div>
</body>
</html>