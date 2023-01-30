package org.zzzzzz.service;

import org.zzzzzz.entity.Absent;

import java.util.List;

public interface AbsentService {

    public List<Absent> list();
    public List<Absent> search(String key, String value);

}
