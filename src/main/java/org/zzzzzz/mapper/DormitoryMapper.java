package org.zzzzzz.mapper;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.zzzzzz.entity.Dormitory;

import java.util.List;

public interface DormitoryMapper {
    public List<Dormitory> availableList();

    public void subAvailable(Integer id);
}
