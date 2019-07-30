package com.everis.bootcamp.ejecicio01maven.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.everis.bootcamp.ejecicio01maven.models.entity.Class;

public interface IClassDao extends CrudRepository<Class, Long> {


}