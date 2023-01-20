package org.zzzzzz.service;

import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Dormitory;

import java.util.List;

@Service
public interface DormitoryService {
    public List<Dormitory> availableList();
}
