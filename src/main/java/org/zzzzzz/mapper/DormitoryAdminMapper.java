package org.zzzzzz.mapper;

import org.zzzzzz.entity.DormitoryAdmin;
import org.zzzzzz.service.DormitoryAdminService;

import java.util.List;

public interface DormitoryAdminMapper {

    public List<DormitoryAdmin> list();
    public List<DormitoryAdmin> searchByUsername(String username);
    public List<DormitoryAdmin> searchByName(String name);
    public List<DormitoryAdmin> searchByTelephone(String telephone);

    public void save(DormitoryAdmin dormitoryAdmin);

    public void delete(Integer id);

}
