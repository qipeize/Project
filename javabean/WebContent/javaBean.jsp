<%@page import="javabean.LoginInfo" import="javabean.LoginControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");

		LoginInfo login = new LoginInfo();
		login.setName(uname);
		login.setPassword(upwd);

		LoginControl control = new LoginControl();
		control.addLoginInfo(login);
	%>
</body>
</html>