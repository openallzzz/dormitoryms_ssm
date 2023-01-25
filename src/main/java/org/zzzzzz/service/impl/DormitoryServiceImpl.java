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

    @Override
    public List<Dormitory> list() {
        return this.dormitoryMapper.list();
    }

    @Override
    public List<Dormitory> search(String key, String value) {
        List<Dormitory> list = null;
        if(value.equals("")) {
            list = this.dormitoryMapper.list();
        } else {
            switch (key) {
                case "name" :
                    list = this.dormitoryMapper.searchByName(value);
                    break;
                case "telephone" :
                    list = this.dormitoryMapper.searchByTelephone(value);
                    break;
            }
        }
        return list;
    }

    @Override
    public void save(Dormitory dormitory) {
        try {
            this.dormitoryMapper.save(dormitory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
