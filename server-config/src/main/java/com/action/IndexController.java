package com.action;

import com.action.utils.ApiResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liuran1991 on 2020/5/27.
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class IndexController {

    @Value("${user.config}")
    private String userConfig;

    @RequestMapping("/get")
    public ApiResult getConfig() {
        return new ApiResult().save("config", userConfig);
    }


}
