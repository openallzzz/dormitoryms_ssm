package org.zzzzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Absent;
import org.zzzzzz.entity.DormitoryAdmin;
import org.zzzzzz.mapper.AbsentMapper;
import org.zzzzzz.service.AbsentService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AbsentServiceImpl implements AbsentService {

    @Autowired
    private AbsentMapper absentMapper;

    @Override
    public List<Absent> list() {
        return absentMapper.list();
    }

    @Override
    public List<Absent> search(String key, String value) {
        if(value.equals("")) return absentMapper.list();
        List<Absent> list = null;
        switch (key) {
            case "buildingName" :
                list = this.absentMapper.searchByBuildingName(value);
                break;
            case "dormitoryName" :
                list = this.absentMapper.searchByDormitoryName(value);
                break;
        }
        return list;
    }

    @Override
    public void save(Absent absent) {
        try {
            this.absentMapper.save(absent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
