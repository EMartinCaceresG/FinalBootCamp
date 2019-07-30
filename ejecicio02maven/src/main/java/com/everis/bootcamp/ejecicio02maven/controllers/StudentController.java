package com.everis.bootcamp.ejecicio02maven.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.bootcamp.ejecicio02maven.models.entity.Student;
import com.everis.bootcamp.ejecicio02maven.models.service.IStudentService;
import com.everis.bootcamp.ejecicio02maven.utils.ClassNotFoundException;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id){
        Student student = studentService.findById(id);
        if (student == null)
            throw new ClassNotFoundException("El estudiante con el id-" + id + " no existe!");

        return student;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Student update(@Valid @RequestBody Student student, @PathVariable Long id){
        Student studentCurrent = studentService.findById(id);

        if (studentCurrent == null)
            throw new ClassNotFoundException("La clase con el id-" + id + " no existe!");

        studentCurrent.setName(student.getName());
        studentCurrent.setLastname(student.getLastname());
        studentCurrent.setDateofbirth(student.getDateofbirth());
        studentCurrent.setDni(student.getDni());

        return studentService.save(studentCurrent);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Student student = studentService.findById(id);

        if (student == null)
            throw new ClassNotFoundException("El estudiante con el id-" + id + " no existe!");

        studentService.delete(id);
    }

}