package org.zzzzzz.mapper;

import org.zzzzzz.entity.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> list();

    public List<Student> searchByNumber(String number);

    public List<Student> searchByName(String name);
}
