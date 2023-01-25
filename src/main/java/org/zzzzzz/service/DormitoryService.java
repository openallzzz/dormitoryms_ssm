package org.zzzzzz.service;

import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Dormitory;

import java.util.List;

@Service
public interface DormitoryService {
    public List<Dormitory> availableList();
    public List<Dormitory> list();

    public List<Dormitory> search(String key, String value);

    public void save(Dormitory dormitory);
}
