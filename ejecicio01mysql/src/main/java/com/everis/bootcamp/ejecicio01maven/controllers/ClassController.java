package com.everis.bootcamp.ejecicio01maven.controllers;

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

import com.everis.bootcamp.ejecicio01maven.models.entity.Class;
import com.everis.bootcamp.ejecicio01maven.models.service.IClassService;
import com.everis.bootcamp.ejecicio01maven.utils.ClassNotFoundException;

@RestController
@RequestMapping(value = "/api/class")
public class ClassController {

    @Autowired
    private IClassService classService;

    @GetMapping
    public List<Class> findAll(){
        return classService.findAll();
    }

    @GetMapping("/{id}")
    public Class findById(@PathVariable Long id){
        Class classes = classService.findById(id);
        if (classes == null)
            throw new ClassNotFoundException("La clase con el id-" + id + " no existe!");

        return classes;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Class create(@Valid @RequestBody Class classes){
        return classService.save(classes);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Class update(@Valid @RequestBody Class classes, @PathVariable Long id){
        Class classesCurrent = classService.findById(id);

        if (classesCurrent == null)
            throw new ClassNotFoundException("La clase con el id-" + id + " no existe!");

        classesCurrent.setClass_name(classes.getClass_name());
        classesCurrent.setClass_code(classes.getClass_code());
        classesCurrent.setDate_start(classes.getDate_start());
        classesCurrent.setDate_end(classes.getDate_end());

        return classService.save(classesCurrent);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Class student = classService.findById(id);

        if (student == null)
            throw new ClassNotFoundException("La clase con el id-" + id + " no existe!");

        classService.delete(id);
    }

}