 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>妞妞商城</title>
    <!--链接外部样式-->
    <link rel="stylesheet" href="style/headerStyle.css">
    <!--设置标签图标-->
    <link href="favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="style/footerStyle.css">
</head>
<body>
<!--头部-->
<div id="header">
<!--头部登录，购物车-->
<div class="header_top">
        <!--中部-->
        <div class="header_top_center">
            <!--中部左侧-->
            <div class="h_top_left">
                欢迎来到妞妞商城
            </div>
            <!--中部右侧-->
            <div class="h_top_right">
            <!--有没有用户  session -->
            <c:if test="${empty user }">
           		 <a href="login.jsp">登录</a>
                <a href="regist.jsp">免费注册</a>
            </c:if>
            
             <c:if test="${!empty user }">
           		<%-- 欢迎： ${user.username } --%>
           		<a href="user_info.jsp">欢迎： ${user.username }</a>
                <a href="login.jsp">退出</a>
            </c:if>
            	
                <a href="goods_car.jsp">购物车</a>
                <a href="goods_list.jsp">我的订单</a>
            </div>
        </div>
</div>

<!--中部搜索-->
<div class="header_center">
    <!--版心-->
    <div class="h_c_center">

        <!--左侧logo-->
        <div class="h_c_logo">
            <img src="images/nn.png" alt="">
        </div>

        <!--中部搜索-->
        <div class="h_c_search">

            <form action="#">
                <input type="text" placeholder="请输入想要的宝贝..." class="s_input">
                <input type="submit" value="搜索" class="s_button">
            </form>

            <div class="hot">
                <a href="#">笔记本</a>
                <a href="#">手机</a>
                <a href="#">3C数码配件</a>
                <a href="#">数码相机</a>
                <a href="#">智能设备</a>
            </div>
        </div>
        <!--右部二维码-->
        <div class="h_c_code">
            <img src="images/pcode.png" alt="">
        </div>
    </div>
</div>

<!--导航-->
 <div id="nav">
     <ul>
         <li><a href="/Mystore/index.jsp">首页</a></li>
         <li><a href="/Mystore/GoodsServlet?id=1">电脑办公</a></li>
         <li><a href="/Mystore/GoodsServlet?id=2">手机通信</a></li>
         <li><a href="/Mystore/GoodsServlet?id=3">智能设备</a></li>
         <li><a href="/Mystore/GoodsServlet?id=4">摄影影像</a></li>
         <li><a href="/Mystore/GoodsServlet?id=5">电子教育</a></li>
     </ul>
 </div>   

</div>
    