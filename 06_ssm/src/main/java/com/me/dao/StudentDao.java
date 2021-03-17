package com.me.dao;

import com.me.pojo.Student;

import java.util.List;

public interface StudentDao {

    int insert(Student student);

    List<Student> selectStudents();

}
