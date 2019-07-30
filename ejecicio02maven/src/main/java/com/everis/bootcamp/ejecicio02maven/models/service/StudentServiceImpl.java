package com.everis.bootcamp.ejecicio02maven.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.everis.bootcamp.ejecicio02maven.models.dao.IStudentDao;
import com.everis.bootcamp.ejecicio02maven.models.entity.Student;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao classDao;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) classDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return classDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return classDao.save(student);
    }

    @Override
    @Transactional
    public void delete(Long id) {
    	classDao.deleteById(id);
    }

}
