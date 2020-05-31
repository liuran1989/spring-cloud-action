package com.action;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient      //开启Nacos服务注册
@MapperScan("com.action.mapper")
public class ServerProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServerProvider1Application.class, args);
    }

}
