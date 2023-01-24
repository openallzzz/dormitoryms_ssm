package org.zzzzzz.mapper;

import org.zzzzzz.entity.Building;

import java.util.List;

public interface  BuildingMapper {
    public List<Building> list();

    public List<Building> searchByName(String name);
    public List<Building> searchByIntrodution(String introduction);

    public void save(Building building);
    public void update(Building building);
    public void delete(Integer id);

}
