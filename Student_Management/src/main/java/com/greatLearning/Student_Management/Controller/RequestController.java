package com.greatLearning.Student_Management.Controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatLearning.Student_Management.Model.Student;
import com.greatLearning.Student_Management.Service.StudentServiceImplementation;


@Controller
@RequestMapping("/student")
public class RequestController {
@Autowired
StudentServiceImplementation data;
@RequestMapping("/") 
public String printStudentData(Model m1){
	List<Student> l1 = data.listAllData();
	/*
	 * for(Student s1:l1) {
	 * System.out.println(s1.getFullName()+" "+s1.getId()+" "+s1.getCountry()+" "+s1
	 * .getDept()+" "); }
	 */
	m1.addAttribute("result",l1);
	return "student";
	
}
@RequestMapping("/add")
public String addBook(Model theModel) {
	Student s1= new Student();
	theModel.addAttribute("result",s1);
	return "studentSave";
}

@RequestMapping("/update")
public String updateBook(@RequestParam("id") int id,Model theModel) {
	Student s1 = data.getStudentDetails(id);
	theModel.addAttribute("result", s1);
	return "studentSave";
}

@RequestMapping("/delete")
public String deleteBook(@RequestParam("id") int id) {
	data.delete(id);
	return "redirect:/student/";
}
@PostMapping("/save")
public String saveDetails(@RequestParam("id") int id, @RequestParam("name") String name,
		@RequestParam("dept") String dept, @RequestParam("country") String country) {
	Student s1;
	if(id != 0) {
		s1 = data.getStudentDetails(id);
	}else {
		s1 = new Student();
	}
	s1.setFullName(name);
	s1.setCountry(country);
	s1.setDept(dept);
	data.save(s1);
	return "redirect:/student/";
}
@RequestMapping("/403")
public ModelAndView delete(Principal user) {
	ModelAndView model = new ModelAndView();
	if(user != null) {
		model.addObject("msg", "Hi "+user.getName()+", you don't have permission to perform this action");
	}else {
		model.addObject("msg", "Hi, you don't have permission to perform this action");
	}
	model.setViewName("error");
	return model;
}
}
