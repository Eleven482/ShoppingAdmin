<%@page import="domain.User"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.dbutils.QueryRunner"%>
<%@page import="org.apache.commons.dbutils.handlers.BeanListHandler"%>
<%@page import="util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>

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
<title>个人信息</title>
<!--链接外部样式-->
<link rel="stylesheet" href="style/index.css">
<link rel="stylesheet" href="style/pageStyle.css">
</head>
<body>
	<!-- 通过jsp指令导入头部 -->
	<%@ include file="/header.jsp"%>

	<div id="ad">
		<div>
			<ul>
				<%
					/* //从域中取数据
					List<User> allUser = (List<User>)request.getAttribute("allUsers");
					System.out.println(allUser);
					if(allUser != null){
						//取出个人信息
						
					}else{
						out.write("暂时没有信息");
					} */

					//1.连接数据库
					QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
					//2.从数据库当中获取数据
					String sql = "select * from user";
					List<User> allUser = null;
					try {

						allUser = qr.query(sql, new BeanListHandler<User>(User.class));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println(allUser);
					for (User users : allUser) {
						out.write("<li>");
						out.write("<p> 昵     称：" + users.getUsername() + "</p>");
						out.write("<p> 密     码：" + users.getPassword() + "</p>");
						out.write("<p> 手机号：" + users.getPhone() + "</p>");
						out.write("</li>");
					}
				%>
				<li>
				<a href="${ctx }/UserEditUIServlet?uid=1">
				<button>编辑</button>
				</a>
				</li>
				<%-- <c:forEach items="${allUser }" var="users">
					<li>
						<p>${users.username }</p>
						<p>${users.password }</p>
						<p>${users.phone }</p>
					</li>
				</c:forEach> --%>


			</ul>
		</div>

	</div>
	<%@ include file="/footer.jsp"%>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
</body>
</html>


