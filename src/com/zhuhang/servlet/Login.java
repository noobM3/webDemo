package com.zhuhang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        ORMSystem orm = new ORMSystem();
        HttpSession session = request.getSession();
        if(orm.login(sno, sname))//数据库中存在该学生
        {
			session.setAttribute("sno", sno);
			session.setAttribute("sname", sname);
			response.setHeader("request_auth", "1");
        }
        else
        {
			session.setAttribute("sno", sno);
			session.setAttribute("sname", sname);
			response.setHeader("request_auth", "0");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        ORMSystem orm = new ORMSystem();
        HttpSession session = request.getSession();
        if(orm.login(sno, sname))//数据库中存在该学生
        {
			session.setAttribute("sno", sno);
			session.setAttribute("sname", sname);
			response.setHeader("request_auth", "1");//设置响应头信息标志位
        }
        else
        {
			session.setAttribute("sno", sno);
			session.setAttribute("sname", sname);
			response.setHeader("request_auth", "0");
        }
	}

}
