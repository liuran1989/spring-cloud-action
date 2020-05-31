package com.action.http;

import com.action.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Tianlang1991
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Component
public class ServerProviderFallBack implements ServerProviderHttp {

    @Autowired
    private ListOperations listOperations;

    @Override
    public ApiResult getList(Integer id) {
        return null;
    }

    @Override
    public ApiResult get(Integer id) {
        return null;
    }

    @Override
    public ApiResult select(String name, Integer value) {
        return null;
    }

    @Override
    public ApiResult save(Object json) {
        return null;
    }

    @Override
    public ApiResult wait(String waitTime) {
        List list = listOperations.range("list", 1, -1);
        return new ApiResult()
                .save("serverId", "api")
                .save("list", list);
    }
}
