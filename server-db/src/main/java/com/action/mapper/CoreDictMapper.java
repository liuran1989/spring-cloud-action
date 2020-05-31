package com.action.mapper;

import com.action.model.CoreDict;

import java.util.List;
import java.util.Map;

public interface CoreDictMapper {

    List<CoreDict> selectCoreDictList(Integer id);

    List<CoreDict> selectByMap(Map<String, Object> map);
}