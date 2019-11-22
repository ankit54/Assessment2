package com.manthan.servletjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.manthan.beans.StudentInfoBean;
import com.manthan.dao.StudentDao;
import com.manthan.dao.StudentDaoImpl;


@WebServlet("/addStudentJsp")
public class AddStudent extends HttpServlet {
	private StudentDao dao=new StudentDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		//HttpSession session=req.getSession(false);
		//if(session!=null){
			//EmployeeInfoBeans beans=(EmployeeInfoBeans) req.getAttribute("employeeInfoBean");
			
			//get the form data
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			int age=Integer.parseInt(req.getParameter("age"));
			String gender=req.getParameter("gender");
			
			
			StudentInfoBean studentInfoBean=new StudentInfoBean();
			studentInfoBean.setUsername(username);
			studentInfoBean.setPassword(password);
			studentInfoBean.setAge(age);
			studentInfoBean.setGender(gender);
			
			
			
			
			if(dao.addStudent(studentInfoBean)) {
				req.setAttribute("addedMsg", "Student Added!! Please login to continue..");
				req.getRequestDispatcher("./loginForm").forward(req, resp);
			}else {
				req.setAttribute("addedMsg", "Student already exists. Please enter other username!!");
				req.getRequestDispatcher("./addStudent").forward(req, resp);
			}
			
		}//end of if-else()
	
	}// end of doPost()

