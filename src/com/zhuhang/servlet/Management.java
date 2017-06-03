package com.zhuhang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Management
 */
@WebServlet("/management")
public class Management extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Management() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter  out=response.getWriter();
		response.setContentType("text/plain");
	    ORMSystem orm = new ORMSystem();
	    String sql = "select * from student;";
	    Student student = new Student();
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		List<Student> students = (List)orm.executeQuery(sql,student);//arraylist-->获取所有学生对象
	    JSONArray jsonStu = JSONArray.fromObject(students);
		out.write(jsonStu.toString());//写入json对象字符串
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
