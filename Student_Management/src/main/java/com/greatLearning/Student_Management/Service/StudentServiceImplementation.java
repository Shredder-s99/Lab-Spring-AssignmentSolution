package com.greatLearning.Student_Management.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.Student_Management.Model.Student;
import com.greatLearning.Student_Management.repository.StudentDao;

@Service
public class StudentServiceImplementation implements StudentServiceInterface{
	@Autowired
	StudentDao studentInterface;
	@Override
	public List<Student> listAllData() {
		//List<Student> l1 = studentInterface.findAll();
		return studentInterface.findAll();
	}

	@Override
	public void save(Student s1) {
		studentInterface.save(s1);
	}

	@Override
	public void delete(int id) {
		studentInterface.deleteById(id);
	}

	@Override
	public Student getStudentDetails(int id) {
		return studentInterface.getReferenceById(id);
	}

}
