package com.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentDao;
import com.demo.model.Student;
import com.demo.requestbean.StuRequestBean;
import com.demo.requestbean.StuRequestBeanForName;
import com.demo.requestbean.StuRequestBeanForUpdate;
import com.demo.requestbean.StuRequestBeanGetId;
import com.demo.responsebean.GenerateMessage;
import com.demo.responsebean.StuResponseBean;
import com.demo.service.StudentService;
import com.demo.utility.Constants;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public GenerateMessage saveStudent(StuRequestBean stBean) {

		Student stu = new Student();
		stu.setName(stBean.getName());
		stu.setMobileNo(stBean.getMobileNo());
		stu.setAddress(stBean.getAddress());

		studentDao.save(stu);

		return new GenerateMessage(stu.getId(), Constants.SUCCESS_MESSAGE);
	}

	@Override
	public GenerateMessage deleteStudent(StuRequestBeanGetId stBId) {
		GenerateMessage message;
		try {
			studentDao.deleteById(stBId.getId());
			message = new GenerateMessage(stBId.getId(), "Delete success");
		} catch (Exception e) {
			message = new GenerateMessage(stBId.getId(), "record Not found");
		}
		return message;
	}

	@Override
	public StuResponseBean getStudentById(StuRequestBeanGetId stBean) {
		StuResponseBean result;
		try {
			Student stu = studentDao.findById(stBean.getId()).get();
			result = this.getResponse(stu);
		} catch (Exception e) {

			result = null;

		}
		return result;

	}

	@Override
	public GenerateMessage updateStudent(StuRequestBeanForUpdate stBean) {
		GenerateMessage genrateMessage;

		Optional<Student> result = studentDao.findById(stBean.getId());
		if (result.isPresent()) {
			Student stu = result.get();
			stu.setAddress(stBean.getAddress());
			stu.setMobileNo(stBean.getMobileNo());
			stu.setName(stBean.getName());
			studentDao.save(stu);
			genrateMessage = new GenerateMessage(stBean.getId(), "Update Success");
		} else {
			genrateMessage = new GenerateMessage(null, "Record Not found");
		}
		return genrateMessage;
	}

	@Override
	public java.util.List<Student> getAllData() {

		return studentDao.findAll();
	}

	public StuResponseBean findByName(StuRequestBeanForName stu) {

		Optional<Student> result = studentDao.findByName(stu.getName());
		if (result.isPresent()) {
			Student s = result.get();
			return this.getResponse(s);
		} else {
			return null;
		}
	}

	public StuResponseBean getResponse(Student stu) {
		StuResponseBean response = new StuResponseBean();
		response.setId(stu.getId());
		response.setName(stu.getName());
		response.setAddress(stu.getAddress());
		response.setMobileNo(stu.getMobileNo());
		return response;
	}

}
