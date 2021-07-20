package com.swar.services;

import java.util.ArrayList;
import java.util.List;

import com.swar.model.Student;

public class StudentResourceService {
	
	List<Student> students;
	static StudentResourceService studentResource=null;
	
	private StudentResourceService() {
		//generate default students
		students = new ArrayList<Student>();
		students.add(new Student(11, "Dummy1", 15));
		students.add(new Student(14, "Dummy2", 15));
		students.add(new Student(33, "Dummy3", 15));
	}
	
	public Student getStudentById(int id) {
		for(Student s: students) {
			if(s.getId()==id)
				return s;
		}
		return null;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public static StudentResourceService getStudentInstance() {
		if(studentResource!=null) {
			return studentResource;
		}
		studentResource = new StudentResourceService();
		return studentResource;
	}

}
