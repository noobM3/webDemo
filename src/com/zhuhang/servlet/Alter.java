package com.zhuhang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alter")
public class Alter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Alter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    MyDBConnection conn = new MyDBConnection();
	    //TODO
	    String oldSno = request.getParameter("oldSno");
	    String sno = request.getParameter("sno");
	    String sname = request.getParameter("sname");
	    String age = request.getParameter("age");
	    String sex = request.getParameter("sex");
	    String depart = request.getParameter("depart");
	    StringBuffer sql = new StringBuffer("update student set");
	    sql.append(" sno = '").append(sno).append("',sname = '").append(sname)
	    .append("',age = '").append(Integer.parseInt(age)).append("',sex = '")
	    .append(sex).append("',depart = '").append(depart).append("' ")
	    .append("where sno = '").append(oldSno).append("';");
	    PrintWriter out = response.getWriter();
	    String sqlString = sql.toString();
	    out.print(sqlString);
	    conn.executeUpdate(sqlString);
	    response.sendRedirect("management.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
