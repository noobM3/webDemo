<%@page import="com.zhuhang.servlet.MyDBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
</head>
<body>
    <form action="alter" method="post">
      <input type="hidden" name = "oldSno" value="<%=request.getParameter("sno")%>">
    学号:<input type="text" name = "sno" value="<%=request.getParameter("sno")%>"><br><br>
    姓名:<input type="text" name = "sname" value="<%=request.getParameter("sname")%>"><br><br>
    年龄:<input type="text" name = "age" value="<%=request.getParameter("age")%>"><br><br>
    性别:<input type="text" name = "sex" value="<%=request.getParameter("sex")%>"><br><br>
    院系:<input type="text" name = "depart" value="<%=request.getParameter("depart")%>"><br><br>
    <input type="submit" value="修改">
    </form>
<!-- 	<script type="text/javascript">
		n_sno    = document.getElementById("sno");
		n_sname  = document.getElementById("sname");
		n_age    = document.getElementById("age");
		n_sex    = document.getElementById("sex");
		n_depart = document.getElementById("depart");
	</script> -->
</body>
</html>