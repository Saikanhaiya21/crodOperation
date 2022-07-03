package com.demo.service;

import com.demo.model.Student;
import com.demo.requestbean.StuRequestBean;
import com.demo.requestbean.StuRequestBeanForName;
import com.demo.requestbean.StuRequestBeanForUpdate;
import com.demo.requestbean.StuRequestBeanGetId;
import com.demo.responsebean.GenerateMessage;
import com.demo.responsebean.StuResponseBean;

import java.util.List;

public interface StudentService {

	public abstract GenerateMessage saveStudent(StuRequestBean stBean);

	public abstract GenerateMessage deleteStudent(StuRequestBeanGetId stBId);

	public abstract StuResponseBean getStudentById(StuRequestBeanGetId stBean);

	public abstract GenerateMessage updateStudent(StuRequestBeanForUpdate stBean);

	public abstract List<Student> getAllData();

	public abstract StuResponseBean findByName(StuRequestBeanForName stu);

}
