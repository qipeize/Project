<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
	学号：<input name="sno"/><br/>
	姓名：<input name ="sname"/><br/>
	<input type="file" name="myfile" value="上传文件">
	<input type="submit" value="增加"/>
	
	</form>
	<a href ="DownloadServlet?fileName=图片.jpg">文件下载</a>
</body>
</html>