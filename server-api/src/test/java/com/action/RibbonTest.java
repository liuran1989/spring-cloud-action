package com.action;

import com.action.utils.ApiResult;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Liuran1991 on 2020/5/29.
 */
@SpringBootTest
public class RibbonTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getTest() {
        ApiResult forObject = restTemplate.getForObject("http://server-provider/server/data/1", ApiResult.class);
        System.out.println(JSON.toJSONString(forObject));
    }

    @Test
    public void postTest() {
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.set("id", "2");
        ApiResult forObject = restTemplate.postForObject("http://server-provider/server/data/get", map, ApiResult.class);
        System.out.println(JSON.toJSONString(forObject));
    }

}
