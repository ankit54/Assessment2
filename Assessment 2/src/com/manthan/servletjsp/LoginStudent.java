package com.manthan.servletjsp;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.beans.StudentInfoBean;
import com.manthan.dao.StudentDao;
import com.manthan.dao.StudentDaoImpl;



@WebServlet("/loginStudentJsp")
public class LoginStudent extends HttpServlet{
	StudentDao dao=new StudentDaoImpl();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=(req.getParameter("username"));
		String password=(req.getParameter("password"));
		HttpSession sessionAttempt=req.getSession();
		sessionAttempt.setAttribute("count", 3);
		StudentInfoBean studentInfoBean=dao.auth(username, password);
		if(studentInfoBean!=null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("studentInfoBean", studentInfoBean);
			req.getRequestDispatcher("/homePage").forward(req, resp);
		}else {
			int c=(int)sessionAttempt.getAttribute("count");
			c--;
			sessionAttempt.setAttribute("count", c);
			if((int)sessionAttempt.getAttribute("count")>0 && (int)sessionAttempt.getAttribute("count")<4) {
				req.setAttribute("invalidMessage", "Invalid id or password... You have "+c+" attempts!!!");
			}else {
				sessionAttempt.setAttribute("count", null);
				req.setAttribute("invalidMessage", "Sorry!! your account has been locked by the Admin.");;
			}
			req.getRequestDispatcher("/loginForm").forward(req, resp);
		}

	}
}
