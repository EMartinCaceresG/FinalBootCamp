package com.everis.bootcamp.ejecicio01maven.models.service;

import java.util.List;

import com.everis.bootcamp.ejecicio01maven.models.entity.Class;

public interface IClassService {

    List<Class> findAll();

    Class findById(Long id);

    Class save(Class classes);

    void delete(Long id);

}
