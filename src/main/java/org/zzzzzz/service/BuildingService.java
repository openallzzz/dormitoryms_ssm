package org.zzzzzz.service;

import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Building;

import java.util.List;

@Service
public interface BuildingService {
    public List<Building> list();

    public List<Building> search(String key, String value);

    public void save(Building building);

    public void update(Building building);
}
