package org.zzzzzz.service;

import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> list();

    public List<Student> search(String key, String value);

    public void save(Student student);

    public void update(Student student);

    public void delete(Student student);

    public List<Student> moveoutList();
}
