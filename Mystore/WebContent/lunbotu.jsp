<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>轮播图的实现</title>
<link rel="stylesheet" href="style/lunbostyle.css">
</head>
<body>
	<!--建立一个div标签并使用ID属性标签类进行唯一标示操作-->
	<div id="box">
		<ul>
			<!--ul为无序列表标签,li标签对象用于进行项目列表的定义操作,即在当前项目对象之前添加一个小圆点-->
			<li class="img-li"><img src="images/adver1.jpg"></li>
			<li class="img-li"><img src="images/adver2.jpg"></li>
			<li class="img-li"><img src="images/adver3.jpg"></li>
			<li class="img-li"><img src="images/adver.jpg"></li>
		</ul>
		<!--在当前div当中嵌套两个div来作为图片切换的按钮-->
		<div id="previous" class="img-button">《</div>
		<div id="next" class="img-button">》</div>
		<!--div盒子模型当中建立两个按钮标签来进行图片的切换结束-->

		<!-- 建立轮播图按钮对象开始 -->
		<ul class="button-ul">
			<!-- ul为无序列表标签 -->
			<li class="button-li" id="one"></li>
			<li class="button-li" id="two"></li>
			<li class="button-li" id="three"></li>
			<li class="button-li" id="four"></li>
		</ul>

		<!-- 建立轮播图按钮对象结束 -->
	</div>
	<script type="text/javascript" src="js/lunbo.js"></script>
</body>
</html>
