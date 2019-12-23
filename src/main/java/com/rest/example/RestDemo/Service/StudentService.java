package com.rest.example.RestDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.example.RestDemo.Exception.DataNotFoundException;
import com.rest.example.RestDemo.Jpa.StudentInterface;
import com.rest.example.RestDemo.Model.Response;
import com.rest.example.RestDemo.Model.Student;

@Service
public class StudentService {
 
	@Autowired
	StudentInterface studentInterface;
	
	@Autowired
	Response response;
	
	public Response addStudent(Student student) {
		Student s = studentInterface.save(student);
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Successfully inserted Student object by ID : "+s.getStudentId());
		return response;
	}
	
	public List<Student> getAllStudent(){
		List<Student> s = studentInterface.findAll();
		if(s.isEmpty())
			throw new DataNotFoundException("Students data not found");
		else
			return s;
	}
	
	public Student getStudentById(int id) {
		return studentInterface.findById(id).orElseThrow(() -> new DataNotFoundException("Student data not present for ID "+id));
	}
	
	public Response updateStudent(int id,Student student) {
		Student s = studentInterface.findById(id).orElseThrow(() -> new DataNotFoundException("Student data not present for ID "+id));
		s.setName(student.getName());
		s.setAddress(student.getAddress());
		s.setSemester(student.getSemester());
		s.setDepartment(student.getDepartment());
		s = studentInterface.save(s);
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Successfully updated Student object by ID : "+s.getStudentId());
		return response;
	}
}
