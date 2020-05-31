package com.action.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Liuran1991 on 2020/5/26.
 */
@ConfigurationProperties(prefix = "nacos")
@Component
@Data
@RefreshScope
public class NacosConfig {

    private String env;

    private String code;

    private String name;

    private List<String> type;

}
