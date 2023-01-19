package org.zzzzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzzzz.entity.DormitoryAdmin;
import org.zzzzzz.mapper.DormitoryAdminMapper;
import org.zzzzzz.service.DormitoryAdminService;

import java.util.List;

@Service
public class DormitoryAdminServiceImpl implements DormitoryAdminService {

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public List<DormitoryAdmin> list() {
        return this.dormitoryAdminMapper.list();
    }
}
