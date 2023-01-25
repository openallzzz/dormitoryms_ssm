package org.zzzzzz.mapper;

import org.zzzzzz.entity.Dormitory;

import java.util.List;

public interface DormitoryMapper {
    public List<Dormitory> availableList();

    public void subAvailable(Integer id);
    public void addAvailable(Integer id);

    public List<Integer> findDormitoryIdByBuildingId(Integer buildingId);

    public Integer findAvailableDormitoryId();

    public void delete(Integer id);

    public void setAvailableToZero(Integer id);

    public List<Dormitory> list();

    public List<Dormitory> searchByName(String name);
    public List<Dormitory> searchByTelephone(String telephone);
}
