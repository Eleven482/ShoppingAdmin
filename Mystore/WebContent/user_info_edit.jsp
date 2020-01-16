<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String ctx = request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>修改个人信息</title>
<link rel="stylesheet" href="${ctx }/style/style.css" type="text/css" />
<link rel="stylesheet" href="${ctx }/style/amazeui.min.css" />
</head>
<body>

	<div class="main_top">
		<div class="am-cf am-padding am-padding-bottom-0">
			<div class="am-fl am-cf">
				<strong class="am-text-primary am-text-lg">修改个人信息</strong><small></small>
			</div>
		</div>
		<hr>

		<div class="edit_content">
			<form action="${ctx }/UserEditServlet" method="post" id="edit_form"
				style="background: none; width: 700px;">
				<div class="item1">
					<input type="text" name="uid" value="${user.uid }" style="display: none">
					<%-- <div>
						<span>uid：</span> 
						<input type="text" class="am-form-field" name="uid" value="${user.uid }">&nbsp;&nbsp;
					</div> --%>
					<div>
						<span>昵&nbsp;&nbsp; 称：</span> 
						<input type="text" class="am-form-field" name="username" value="${user.username }">&nbsp;&nbsp;
					</div>
					<br>
					<div>
						<span>密&nbsp;&nbsp; 码：</span> 
						<input type="text" class="am-form-field" name="password" value="${user.password }">
					</div>
					<br>
					<div>
						<span>手机号：</span> 
						<input type="text" class="am-form-field" name="phone" value="${user.phone }">
					</div>
					<br>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>

				<button class="am-btn am-btn-default" type="button" id="edit">更新</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="am-btn am-btn-default" type="button" id="reset">重置</button>
			</form>
		</div>

	</div>

	<script src="${ctx }/js/jquery.min.js"></script>

	<script>
		$(function() {

			$("#edit").click(function() {
				//让表单提交到USerEditServlet
				//获取表单  让其提交
				$("#edit_form").submit();
			});

		});
	</script>
</body>
</html>