package org.zzzzzz.service;

import org.zzzzzz.entity.Absent;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AbsentService {

    public List<Absent> list();
    public List<Absent> search(String key, String value);

    public void save(Absent absent);

}
