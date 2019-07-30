package com.everis.bootcamp.ejecicio02maven.models.service;

import java.util.List;

import com.everis.bootcamp.ejecicio02maven.models.entity.Student;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(Student student);

    void delete(Long id);

}
