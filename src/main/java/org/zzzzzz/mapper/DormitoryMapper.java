package org.zzzzzz.mapper;

import org.apache.ibatis.type.IntegerTypeHandler;
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
}
