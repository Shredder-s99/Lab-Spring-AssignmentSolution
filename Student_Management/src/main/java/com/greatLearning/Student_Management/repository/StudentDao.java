package com.greatLearning.Student_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatLearning.Student_Management.Model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

}
