package com.everis.bootcamp.ejecicio01maven.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.everis.bootcamp.ejecicio01maven.models.dao.IClassDao;
import com.everis.bootcamp.ejecicio01maven.models.entity.Class;

@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    private IClassDao classDao;

    @Override
    @Transactional(readOnly = true)
    public List<Class> findAll() {
        return (List<Class>) classDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Class findById(Long id) {
        return classDao.findById(id).orElse(null);
    }



    @Override
    @Transactional
    public Class save(Class classes) {
        return classDao.save(classes);
    }

    @Override
    @Transactional
    public void delete(Long id) {
    	classDao.deleteById(id);
    }

}
