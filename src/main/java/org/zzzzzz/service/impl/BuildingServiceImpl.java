package org.zzzzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Building;
import org.zzzzzz.mapper.BuildingMapper;
import org.zzzzzz.mapper.DormitoryMapper;
import org.zzzzzz.mapper.StudentMapper;
import org.zzzzzz.service.BuildingService;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

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
        try {
            this.buildingMapper.save(building);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Building building) {
        try {
            this.buildingMapper.update(building);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            //  查询被删除的楼中的寝室编号集合
            List<Integer> dormitoryIdList = this.dormitoryMapper.findDormitoryIdByBuildingId(id);
            for (Integer dormitoryId : dormitoryIdList) {  //  枚举每个将被删除的宿舍编号
                //  设置当前待删除宿舍的可用床位为零
                this.dormitoryMapper.setAvailableToZero(dormitoryId);
                //  寻找该宿舍中所住的学生编号集合
                List<Integer> studentIdList = this.studentMapper.findStudentIdByDormitoryId(dormitoryId);
                for (Integer studentId : studentIdList) {  //  枚举每个待分配的学生编号
                    //  寻找可用宿舍编号
                    Integer availableDormitoryId = this.dormitoryMapper.findAvailableDormitoryId();
                    if (availableDormitoryId != null) {  //  可用宿舍存在时，进行分配
                        this.studentMapper.resetDormitoryId(studentId, availableDormitoryId);
                        this.dormitoryMapper.subAvailable(availableDormitoryId);
                    }
                }
                //  根据宿舍编号删除宿舍
                this.dormitoryMapper.delete(dormitoryId);
            }
            this.buildingMapper.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
