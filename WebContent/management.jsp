<%@page import="java.lang.reflect.Field"%>
<%@page import="com.zhuhang.servlet.ORMSystem"%>
<%@page import="com.zhuhang.servlet.Student"%>
<%@page import="com.zhuhang.servlet.MyDBConnection"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库管理系统</title>
</head>
<h1>数据库管理系统</h1>
<hr>
<body>
    <%
    ORMSystem orm = new ORMSystem();
    String sql = "select * from student;";
    Student student = new Student();
    List<Object> students = orm.executeQuery(sql,student);//arraylist-->获取所有学生对象
    Field[] fields = students.get(0).getClass().getDeclaredFields();
    %>
    <table border="1">
    
        <tr>
        
        <%
        if(fields != null && fields.length > 0)//避免空指针错误
        {
            for(Field field:fields)
                {
        %>      <%field.setAccessible(true);%>
            <td><%out.print(field.getName());%></td>
        <%
                }
        }
        %>
        <td>操作</td>
        
        </tr>
        
        <%
        for(int i = 0;i < students.size();i++)
        {
        %>
            <tr>
        <%
        	for(int j = 0;j <fields.length;++j)
        	{
        %>	
                <td> 
                    <%
                    out.print(fields[j].get(students.get(i)));
                    %>
                </td>
        <%
        	}
        %>
                <td>
                <a href="alter.jsp?sno=<%=fields[0].get(students.get(i))%>&sname=<%=fields[1].get(students.get(i))%>&age=<%=fields[2].get(students.get(i))%>&sex=<%=fields[3].get(students.get(i))%>&depart=<%=fields[0].get(students.get(i))%>">修改</a>
                <%out.print("&nbsp&nbsp&nbsp");%>
                <a href="delete?sno=<%=fields[0].get(students.get(i))%>">删除</a>
                </td>
            </tr>
        <%
        }
        %>
    </table>
</body>
</html>