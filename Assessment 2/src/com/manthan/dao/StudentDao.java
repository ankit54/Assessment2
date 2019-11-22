package com.manthan.dao;

import com.manthan.beans.StudentInfoBean;

public interface StudentDao {
	public boolean addStudent(StudentInfoBean studentInfoBean);
	public StudentInfoBean auth(String username,String password);
	
}
