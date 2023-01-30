package org.zzzzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Moveout;
import org.zzzzzz.mapper.MoveoutMapper;
import org.zzzzzz.service.MoveoutService;

import java.util.List;

@Service
public class MoveoutServiceImpl implements MoveoutService {

    @Autowired
    private MoveoutMapper moveoutMapper;

    @Override
    public List<Moveout> list() {
        return this.moveoutMapper.list();
    }

    @Override
    public List<Moveout> search(String key, String value) {
        if(value.equals("")) return list();
        List<Moveout> list = null;
        switch (key) {
            case "studentName" :
                list = moveoutMapper.searchByStudentName(value);
                break;
            case "dormitoryName" :
                list = moveoutMapper.searchByDormitoryName(value);
                break;
        }
        return list;
    }
}
