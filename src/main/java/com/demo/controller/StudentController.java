package com.demo.controller;

import com.demo.model.Student;
import com.demo.requestbean.StuRequestBean;
import com.demo.requestbean.StuRequestBeanForName;
import com.demo.requestbean.StuRequestBeanForUpdate;
import com.demo.requestbean.StuRequestBeanGetId;
import com.demo.responsebean.GenerateMessage;
import com.demo.responsebean.StuResponseBean;
import com.demo.service.StudentService;
import com.demo.utility.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.STUDENT_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

	@Autowired
	private StudentService studentService;

	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

	@PostMapping(value = Constants.SAVE_ENDPOINT)
	public ResponseEntity<String> saveStudent(@Valid @RequestBody StuRequestBean stBean) {
		ResponseEntity<String> response;
		GenerateMessage result = this.studentService.saveStudent(stBean);
		response = new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);

		return response;
	}

	@PostMapping(value = Constants.GET_ENDPOINT)
	public ResponseEntity<String> getStudentById(@RequestBody StuRequestBeanGetId stBean) {
		ResponseEntity<String> response;
		StuResponseBean result = this.studentService.getStudentById(stBean);
		if (result != null)
			response = new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
		else
			response = new ResponseEntity<>(gson.toJson(result), HttpStatus.NOT_FOUND);

		return response;
	}

	@PostMapping(value = Constants.DELETE_ENDPOINT)
	public ResponseEntity<String> deleteStudent(@RequestBody StuRequestBeanGetId stBean) {

		ResponseEntity<String> response;
		GenerateMessage result = this.studentService.deleteStudent(stBean);
		if (result.getMessage().equals("success"))
			response = new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
		else
			response = new ResponseEntity<>(gson.toJson(result), HttpStatus.BAD_REQUEST);

		return response;
	}

	@PostMapping(value = Constants.UPDATE_ENDPOINT)
	public ResponseEntity<String> updateStudent(@Valid @RequestBody StuRequestBeanForUpdate stBean) {
		ResponseEntity<String> response;
		GenerateMessage result = this.studentService.updateStudent(stBean);
		if (result.getMessage().equals("Update Success"))
			response = new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
		else
			response = new ResponseEntity<>(gson.toJson(result), HttpStatus.NOT_FOUND);

		return response;
	}
	
	@GetMapping(value = Constants.GETALL_DATA)
	public ResponseEntity<String> getAllData(){
		
		List<Student> list =this.studentService.getAllData();
		
		return new ResponseEntity<>(gson.toJson(list),HttpStatus.OK);
	}
	
	@GetMapping(value = Constants.GETDATABY_NAME)
	public ResponseEntity<String> getStudentByName(@RequestBody StuRequestBeanForName stu){
		StuResponseBean s1 = this.studentService.findByName(stu);
		return new ResponseEntity<>(gson.toJson(s1),HttpStatus.OK);
	}

}
