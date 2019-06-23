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
                <div class="btn-group">
                    <button class="btn-head" id="btn-look">查看留言</button>
                    <c:if test="${not empty currentUser}">
                    <button class="btn-head" id="btn-send">发布留言</button>
                    <c:if test="${currentUser.type == 1}">
                    <button class="btn-head" id="btn-make">修改留言</button>
                    </c:if>
                    </c:if>
                </div>
    </div>
    <div class="content">
        <div class="left">
            <div class="left-title">
                <img src="../../images/msg_content.png" class="icon" />
                <span class="title">留言内容</span>
            </div>
            <ul class="list" >
                <li class="list-li bg-hl" name="li1" id="li1">
                </li>
                <li class="list-li" name="li2" id="li2">
                </li>
                <li class="list-li bg-hl" name="li3" id="li3">
                </li>
                <li class="list-li"  name="li4" id="li4">
                </li>
                <li class="list-li bg-hl" name="li5" id="li5">
                </li>
                <li class="list-li" name="li6" id="li6">
                </li>
                <li class="list-li bg-hl" name="li7" id="li7">
                </li>
                <li class="list-li" name="li8" id="li8">
                </li>
                <li class="list-li bg-hl" name="li9" id="li9">
                </li>
                <li class="list-li" name="li10" id="li10">
                </li>
                <li class="list-li bg-hl" name="li11" id="li11">
                </li>
                <li class="list-li" name="li12" id="li12">
                </li>
                <li class="list-li bg-hl" name="li13" id="li13">
                </li>
                <li class="list-li" name="li14" id="li14">
                </li>
                <li class="list-li bg-hl" name="li15" id="li15">
                </li>
            </ul>
            <div class="btn-group-foot">

                <a class="btn-foot" onclick="perpage()" >上一页</a>
                <a class="btn-foot" onclick="nextpage()">下一页</a>
                <a class="btn-foot" onclick="indexpage()">首 页</a>
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
                        <td valign="top" class="tb-content" name="tb1" id="tb1"></td>
                    </tr>
                    <tr>
                        <td valign="top" class="tb-title">作者：</td>
                        <td valign="top" class="tb-content" name="tb2" id="tb2"></td>
                    </tr>
                    <tr>
                        <td valign="top" class="tb-title">日期：</td>
                        <td valign="top" class="tb-content" name="tb3" id="tb3"></td>
                    </tr>
                    <tr style="height: 50px;">
                        <td valign="top" class="tb-title">内容：</td>
                        <td valign="top" class="tb-content" name="tb4" id="tb4"></td>
                    </tr>


                    <tr style="height: 50px;">
                        <td valign="top" class="tb-title">回复：</td>
                        <td valign="top" class="tb-content" name="tb5" id="tb5"></td>
                    </tr>

                </table>
                <form class="m-t" role="form" action="/updatemessage" method="post">
                <div class="tb" style="display: none;" id="reply-content">

                    <div valign="top" class="tb-title">回复：</div>

                    <textarea type="text" rows="5" cols="30"  name="reply" id="tb6"></textarea>
                    <input type="text" style="display:none" name="inputid" value="1" id="inputid"/>


                    <input type="submit" name="btn1" value="更 改" class="btn-login" />
                </div>
                </form>


                <form class="m-t" role="form" action="/addmessage" method="post">
                <div class="tb" style="display: none;" id="look-content">
                        <td valign="top" class="tb-title">作者： </td>
                        <input type="text" name="user"  readonly="readonly" value="${currentUser.name}" size="40">
                    </tr>

                    <tr class="tb-title">主题：</tr>
                    <input type="text" name="topic" size="40">
                    <tr class="tb-title">内容：</tr>
                    <textarea rows="6" cols="42" type="text" name="content"></textarea>
                    <input type="submit" name="btn" value="发 表" class="btn-login" />
                </div>
                </form>
            </div>
        </div>
    </div>
    <div class="foot"></div>
<%
    int pageno=1;
    int messageid=0;
%>
    <!--尾部-->
    <jsp:include page="include/foot.jsp"/>

    <script type="text/javascript">

        var loading = layer.load(0);

        listProducts(<%=pageno%>);
        //下一页
        function nextpage(){
            <%pageno =pageno+1;%>
            listProducts(<%=pageno%>);
        }
        //上一页
        function perpage(){
            <%
                pageno =pageno-1;
                if(pageno<=0){
                    pageno=1;
                }
            %>
            listProducts(<%=pageno%>);
        }
        //首页
        function indexpage(){
            <%
                    pageno=1;
            %>

            listProducts(<%=pageno%>);
        }
        /**
         * 将请求到的数据显示到页面
         * @param pageno
         */
        function listProducts(pageno) {
            var allProduct = getAllProducts(pageno);
            for(var i=0;i<15;i++){
                var html = "";
                var state = "";
                var id = "li"+(i+1);
                var productArea = document.getElementById(id);
                if (allProduct[i]!=null) {
                    if (allProduct[i].state == 0) {
                        state = '<span class="tag-warm">' + '未解决' + '</span>';
                    } else {
                        state = '<span class="tag-success">' + '已解决' + '</span>';
                    }
                    html += '<span class="li-text">' + allProduct[i].topic + '</span>' + state + '<span class="li-date">' + allProduct[i].createTime + '</span>';
                    var allid= allProduct[i].id;
                    //闭包实现li标签的点击事件
                    (function (allid) {
                        productArea.addEventListener('click',function (){
                            var inputid = "inputid";
                            var inid = document.getElementById(inputid);
                            inid.value=allid;
                            console.log(allid);
                            messageinfo(allid);
                        });
                    }(allid))
                }
                productArea.innerHTML="";
                productArea.innerHTML = html;
            }
            layer.close(loading);
        }
        /**
         * 通过Ajax实现后台数据的请求
         * @param paegno
         * @returns jian
         */
        function getAllProducts( paegno) {
            var allProducts = null;
            var nothing = {};
            $.ajax({
                async : false, //设置同步
                type : 'Get',
                url : '/message/list?pageNo='+paegno,
                data : nothing,
                dataType : 'json',
                success : function(result) {
                    if (result!=null) {
                        allProducts = result.allProducts;
                    }
                    else{
                        layer.alert('查询错误');
                    }
                },
                error : function(resoult) {
                    layer.alert('查询错误');
                }
            });
            //这里的eval方法不同于prase方法，外面加括号
            allProducts = eval("("+allProducts+")");
            return allProducts;
        }

        function messageDetail(id) {
            var productResult = "";
            var product = {};
            product.id = id;

            $.ajax({
                async : false, //设置同步
                type : 'Get',
                url : '/getmessage?id='+id,
                data : product,
                dataType : 'json',
                success : function(result) {
                    if (result!=null) {
                        productResult = result.result;
                    }
                    else{
                        layer.alert('查询错误');
                    }
                },
                error : function(resoult) {
                    layer.alert('查询错误');
                }
            });
            //划重点划重点，这里的eval方法不同于prase方法，外面加括号
            productResult = JSON.parse(productResult);
            return productResult;
        }


        function messageinfo(id) {

            var allProduct = messageDetail(id);
            var state="";
            if (allProduct!=null) {
                for(var i=1; i<=6; i++){
                    var id = "tb"+i;
                    var productArea = document.getElementById(id);
                    if (i==1) {
                        productArea.innerHTML =allProduct.topic;
                    }
                    else if(i==2){
                        productArea.innerHTML=allProduct.userName;
                    }

                    else if(i==3){
                        productArea.innerHTML=allProduct.createTime;
                    }

                    else if(i==4){
                            productArea.innerHTML=allProduct.content;
                    }
                    else if(i==5){
                        if (allProduct.state==0) {
                                state = '<span class="tag-warm">' + '未解决' + '</span>';
                                productArea.innerHTML =state;
                        }else {
                            productArea.innerHTML=allProduct.replyContent;}
                    }
                    else if(i==6){
                        if (allProduct.state==0) {
                            productArea.innerHTML ="";
                        }else {
                            productArea.innerHTML = allProduct.replyContent;
                        }
                    }
                }
            }
            layer.close(loading);
        }




    </script>


</div>
</body>
</html>