package org.zzzzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Student;
import org.zzzzzz.mapper.StudentMapper;
import org.zzzzzz.service.StudentService;

import java.io.PipedReader;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> list() {
        return this.studentMapper.list();
    }
}
