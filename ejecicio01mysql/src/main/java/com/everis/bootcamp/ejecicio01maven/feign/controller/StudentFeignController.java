package com.everis.bootcamp.ejecicio01maven.feign.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.bootcamp.ejecicio01maven.feign.model.Student;
import com.everis.bootcamp.ejecicio01maven.feign.service.StudentFeignService;

@RestController
@RequestMapping("/Students")
public class StudentFeignController {
	
	@Autowired
	private StudentFeignService studentFeignService;
	
	@GetMapping
	public List<Student> findAll(){
		return studentFeignService.findAll();
	}
	
//	@HystrixCommand(fallbackMethod = "MethodAlt")
	
	@GetMapping ("/{id}")
	public Optional<Student> get(@Valid@PathVariable("id") Long id){
		return studentFeignService.get(id);
	}
	
//	public Optional<Student> MethodAlt(@Valid@PathVariable("id") Long id){
//		Student student = new Student();
//		
//		student.setStudent_id(id);
//		student.setName("Enrique");
//		student.setLastname("Caceceres");
//		student.setDateofbirth("1996-01-13");
//		student.setDni("74136701");
//		
//		return Optional.of(student);
//	}
	
	
}
