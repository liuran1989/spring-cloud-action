package com.action.controller;

import com.action.config.NacosConfig;
import com.action.entity.ServerData;
import com.action.enums.EmRetCode;
import com.action.model.CoreDict;
import com.action.service.DataService;
import com.action.utils.ApiResult;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Liuran1991
 * @date 2020/5/28
 */
@RestController
@RequestMapping("/server/data")
@Slf4j
public class IndexController {
    @Value("${server.id}")
    private String serverId;
    @Autowired
    private DataService dataService;
    @Autowired
    private NacosConfig nacosConfig;

    @GetMapping("/{id}")
    public ApiResult getList(@PathVariable Integer id) {
        List<CoreDict> coreDictList = dataService.select(id);
        return new ApiResult()
                .save("serverId", serverId)
                .save("data", coreDictList)
                .save("list", dataService.selectValues())
                .save("setting", JSON.parseObject(JSON.toJSONString(nacosConfig)));
    }

    @PostMapping(value = "/get")
    public ApiResult get(Integer id) {
        List<CoreDict> coreDictList = dataService.select(id);
        return new ApiResult()
                .save("serverId", serverId)
                .save("data", coreDictList);
    }

    @RequestMapping(value = "/select")
    public ApiResult select(String name, Integer value) {
        return new ApiResult()
                .save("serverId", serverId)
                .save("name", name)
                .save("value", value)
                .save("data", dataService.select(name, value.toString()));
    }

    @RequestMapping(value = "/save")
    public ApiResult save(@RequestBody ServerData serverData) {
        String jsonString = JSON.toJSONString(serverData);
        log.info("接收到数据: {}", jsonString);
        return new ApiResult()
                .save("serverId", serverId)
                .save("count", dataService.save(serverData))
                .save("data", JSON.parseObject(jsonString));
    }

    @RequestMapping(value = "/wait")
    public ApiResult wait(@RequestParam(defaultValue = "5000", name = "waitTime") String waitTime) {
        try {
            log.info("处理等待: {}", waitTime);
            Thread.sleep(Long.parseLong(waitTime));
            return new ApiResult()
                    .save("serverId", serverId)
                    .save("sleep", waitTime);
        } catch (Exception e) {
            log.error("线程休眠出错: ", e);
            return new ApiResult(EmRetCode.NETWORK_EXCEPTION);
        }
    }

}
