package com.action.utils;

import com.action.enums.EmRetCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 返回json数据格式
 * Created by pc-tianlang1991 on 2017/7/24.
 */
public class ApiResult extends LinkedHashMap<String,Object> {
    private final static String ret_code  = "errorCode";
    private final static String ret_message  = "errorMsg";

    public ApiResult(){
        this(EmRetCode.SUCCESS);
    }
    public ApiResult(EmRetCode retCode){
        this(retCode.getCode(),retCode.getMessage());
    }

    public ApiResult(EmRetCode retCode, Object... param){
        this(retCode.getCode(),String.format(retCode.getMessage(), param));
    }

    public ApiResult(Integer retCode, String retMessage){
        super.put(ret_code, retCode);
        super.put(ret_message,  retMessage);
    }

    public ApiResult(String retCode, String retMessage){
        super.put(ret_code, retCode);
        super.put(ret_message,  retMessage);
    }

    public ApiResult save(String key, Object value){
        super.put(key, value);
        return this;
    }

    public ApiResult save(Map<String, Object> map){
        if(map != null){
            for (String key : map.keySet()) {
                super.put(key, map.get(key));
            }
        }
        return this;
    }
}
