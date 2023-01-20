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

    public List<Student> search(String key, String value) {
        if(value.equals("")) return studentMapper.list();
        List<Student> list = null;
        switch (key) {
            case "number" :
                list = this.studentMapper.searchByNumber(value);
                break;
            case "name" :
                list = this.studentMapper.searchByName(value);
                break;
        }
        return list;
    }
}
