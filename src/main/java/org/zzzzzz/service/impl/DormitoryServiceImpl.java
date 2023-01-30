package org.zzzzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Dormitory;
import org.zzzzzz.mapper.DormitoryMapper;
import org.zzzzzz.mapper.StudentMapper;
import org.zzzzzz.service.DormitoryService;

import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

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

    @Override
    public void update(Dormitory dormitory) {
        try {
            this.dormitoryMapper.update(dormitory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer dormitoryId) {
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

    @Override
    public List<Dormitory> findByBuildingId(Integer buildingId) {
        return this.dormitoryMapper.findByBuildingId(buildingId);
    }
}
