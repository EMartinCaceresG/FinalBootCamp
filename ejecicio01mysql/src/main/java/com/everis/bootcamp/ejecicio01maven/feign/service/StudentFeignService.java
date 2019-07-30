package com.everis.bootcamp.ejecicio01maven.feign.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.bootcamp.ejecicio01maven.feign.model.Student;

@FeignClient("ejecicio02maven")
public interface StudentFeignService {

	@GetMapping("students")
	public List<Student> findAll();
	
	@GetMapping("students/{id}")
	public Optional<Student> get(@Valid@PathVariable("id") Long id);
}
