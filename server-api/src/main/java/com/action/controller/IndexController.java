package com.action.controller;

import com.action.http.ServerProviderHttp;
import com.action.service.IndexService;
import com.action.utils.ApiResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Liuran1991
 * @date 2020/5/25
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @Autowired
    private IndexService       indexService;
    @Autowired
    private ServerProviderHttp serverProviderHttp;

    @RequestMapping("/get/{id}")
    public ApiResult getById(@PathVariable Integer id) {
        return indexService.select(id);
    }

    //-----------------------------------------------------------------------------------------
    @GetMapping("/feign/{id}")
    public ApiResult getList(@PathVariable Integer id) {
        return serverProviderHttp.getList(id);
    }

    @PostMapping("/feign/get")
    public ApiResult get(Integer id) {
        return serverProviderHttp.get(id);
    }

    @RequestMapping("/feign/select")
    public ApiResult select(String name, Integer value) {
        return serverProviderHttp.select(name, value);
    }

    @PostMapping("/feign/save")
    public ApiResult save(String data, Integer status,
                          @RequestParam(required = false, value = "list[]")List<String> list) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", data);
        jsonObject.put("status", status);
        jsonObject.put("list", list);
        return serverProviderHttp.save(jsonObject);
    }
    //-----------------------------------------------------------------------------------------

    @RequestMapping("/ribbon/wait")
    public ApiResult wait0(Integer waitTime) {
        return indexService.wait(waitTime);
    }

    @RequestMapping("/feign/wait")
    public ApiResult wait(Integer waitTime) {
        return serverProviderHttp.wait(waitTime.toString());
    }



}
