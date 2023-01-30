package org.zzzzzz.service;

import org.springframework.stereotype.Service;
import org.zzzzzz.entity.Moveout;

import java.util.List;

@Service
public interface MoveoutService {
    public List<Moveout> list();
    public List<Moveout> search(String key, String value);
}
