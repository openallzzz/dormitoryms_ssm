package org.zzzzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Student;
import org.zzzzzz.mapper.DormitoryMapper;
import org.zzzzzz.mapper.StudentMapper;
import org.zzzzzz.service.StudentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

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

    @Override
    public void save(Student student) {
        // 添加系统时间作为入住时间
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式转换
        student.setCreateDate(dateFormat.format(data));
        try {
            this.studentMapper.save(student);
            dormitoryMapper.subAvailable(student.getDormitoryId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Student student) {
        try {
            this.studentMapper.update(student);
            if(!student.getDormitoryId().equals(student.getOldDormitoryId())) {
                this.dormitoryMapper.subAvailable(student.getDormitoryId());
                this.dormitoryMapper.addAvailable(student.getOldDormitoryId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Student student) {
        try {
            this.studentMapper.delete(student);
            this.dormitoryMapper.addAvailable(student.getDormitoryId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> moveoutList() {
        return this.studentMapper.moveoutList();
    }
}