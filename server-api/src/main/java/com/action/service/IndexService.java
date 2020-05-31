package com.action.service;

import com.action.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Liuran1991 on 2020/5/25.
 */
@Service
public class IndexService {

    @Autowired
    private RestTemplate restTemplate;

    public ApiResult select(Integer id) {
        MultiValueMap<String,Integer> map = new LinkedMultiValueMap<>();
        map.set("id", id);
        return restTemplate.postForObject("http://server-provider/server/data/get", map, ApiResult.class);
    }

    public ApiResult wait(Integer waitTime) {
        MultiValueMap<String,Integer> map = new LinkedMultiValueMap<>();
        map.set("waitTime", waitTime);
        return restTemplate.postForObject("http://server-provider/server/data/wait", map, ApiResult.class);
    }

}
