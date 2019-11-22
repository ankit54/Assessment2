package com.manthan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.manthan.beans.StudentInfoBean;


public class StudentDaoImpl implements StudentDao {
	

	@Override
	public StudentInfoBean auth(String username, String password) {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StudentInfoBean studentInfoBean=null;

		try {
			//LOAD THE DRIVER
			Class.forName("com.mysql.jdbc.Driver");

			//GET CONNECTION VIA DRIVER
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");

			//ISSUE SQL QUERY 
			String query = " select * from student_info where username=? and password=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				studentInfoBean=new StudentInfoBean(); //creating object of EmployeeInfoBeans
				studentInfoBean.setUsername(rs.getString("username"));
				studentInfoBean.setPassword(rs.getString("password"));
				studentInfoBean.setAge(rs.getInt("age"));
				studentInfoBean.setGender(rs.getString("gender"));
				
			}
		} catch (Exception e) {
		}
		finally {
			//CLOSE JDBC OBJECTS
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//end of finally
		return studentInfoBean;
		
	}

	@Override
	public boolean addStudent(StudentInfoBean studentInfoBean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		boolean isAdded=false;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			String dburl="jdbc:mysql://localhost:3306/student_db";
			conn=DriverManager.getConnection(dburl,"root","root");

			pstmt=conn.prepareStatement("insert into student_info values (?,?,?,?)");

			pstmt.setString(1,studentInfoBean.getUsername());
			pstmt.setString(2, studentInfoBean.getPassword());
			pstmt.setInt(3,studentInfoBean.getAge());
			pstmt.setString(4,studentInfoBean.getGender());
			int n=pstmt.executeUpdate();

			if(n>0) {
				isAdded=true;
			}


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
		return isAdded;
	}//end of addStudent

	
}
