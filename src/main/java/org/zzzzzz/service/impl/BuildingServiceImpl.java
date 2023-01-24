package org.zzzzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Building;
import org.zzzzzz.mapper.BuildingMapper;
import org.zzzzzz.service.BuildingService;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> list() {
        return buildingMapper.list();
    }

    @Override
    public List<Building> search(String key, String value) {
        List<Building> list = null;
        if(value.equals("")) list = buildingMapper.list();
        switch (key) {
            case "name" :
                list = buildingMapper.searchByName(value);
                break;
            case "introduction" :
                list = buildingMapper.searchByIntrodution(value);
                break;
        }
        return list;
    }

    @Override
    public void save(Building building) {
        this.buildingMapper.save(building);
    }
}
