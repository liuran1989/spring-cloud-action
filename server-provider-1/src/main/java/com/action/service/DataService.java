package com.action.service;

import com.action.entity.ServerData;
import com.action.mapper.CoreDictMapper;
import com.action.model.CoreDict;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liuran1991 on 2020/5/28.
 */
@SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection", "rawtypes", "unchecked"})
@Service
public class DataService {

    @Autowired
    private CoreDictMapper coreDictMapper;
    @Autowired
    private HashOperations hashOperations;
    @Autowired
    private ListOperations listOperations;

    public List<CoreDict> select(String name, String value) {
        final Map<String, Object> map = new HashMap<>(4);
        map.put("name", name);
        map.put("value", value);
        return coreDictMapper.selectByMap(map);
    }

    public List<CoreDict> select(Integer id) {
        return coreDictMapper.selectCoreDictList(id);
    }

    public List<String> selectValues() {
        return hashOperations.values("hash");
    }

    public Long save(ServerData serverData) {
        return listOperations.leftPush("list", JSON.toJSON(serverData));
    }
}
