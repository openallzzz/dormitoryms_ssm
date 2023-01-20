package org.zzzzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Dormitory;
import org.zzzzzz.mapper.DormitoryMapper;
import org.zzzzzz.service.DormitoryService;

import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Dormitory> availableList() {
        return this.dormitoryMapper.availableList();
    }
}
