package org.zzzzzz.service;

import org.springframework.stereotype.Service;
import org.zzzzzz.entity.DormitoryAdmin;

import java.util.List;

@Service
public interface DormitoryAdminService {

    public List<DormitoryAdmin> list();

    public List<DormitoryAdmin> search(String key, String value);

}
