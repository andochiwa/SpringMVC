package com.me.service.impl;

import com.me.dao.StudentDao;
import com.me.pojo.Student;
import com.me.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public List<Student> findStudent() {
        return studentDao.selectStudents();
    }
}
