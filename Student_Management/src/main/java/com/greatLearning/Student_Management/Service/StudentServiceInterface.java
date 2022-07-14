package com.greatLearning.Student_Management.Service;

import java.util.List;

import com.greatLearning.Student_Management.Model.Student;

public interface StudentServiceInterface {
	public List<Student> listAllData();
	public void save(Student s1);
	public void delete(int id);
	public Student getStudentDetails(int id);
}
