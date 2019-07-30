package com.everis.bootcamp.ejecicio02maven.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.everis.bootcamp.ejecicio02maven.models.entity.Student;

public interface IStudentDao extends CrudRepository<Student, Long> {


}