package com.action;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


/**
 * @author Tianlang1991
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApiApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(2000);
        factory.setReadTimeout(2000);
        return new RestTemplate(factory);
    }

    /**
     * 配置负载均衡规则
     * 内置负载均衡规则类：
     * 1、RoundRobinRule：简单轮询服务列表来选择服务器。它是Ribbon默认的负载均衡规则。
     * 2、AvailabilityFilteringRule：
     *    对以下两种服务器进行忽略：
     *   （1）在默认情况下，这台服务器如果3次连接失败，这台服务器就会被设置为“短路”状态。
     *        短路状态将持续30秒，如果再次连接失败，短路的持续时间就会几何级地增加。
     *    注意：可以通过修改配置loadbalancer.<clientName>.connectionFailureCountThreshold来修改连接失败多少次之后被设置为短路状态。默认是3次。
     *   （2）并发数过高的服务器。如果一个服务器的并发连接数过高，配置了AvailabilityFilteringRule规则的客户端也会将其忽略。
     *        并发连接数的上线，可以由客户端的<clientName>.<clientConfigNameSpace>.ActiveConnectionsLimit属性进行配置。
     * 3、WeightedResponseTimeRule：为每一个服务器赋予一个权重值。服务器响应时间越长，这个服务器的权重就越小。
     *                              这个规则会随机选择服务器，这个权重值会影响服务器的选择。
     * 4、ZoneAvoidanceRule：以区域可用的服务器为基础进行服务器的选择。使用Zone对服务器进行分类，这个Zone可以理解为一个机房、一个机架等。
     * 5、BestAvailableRule：忽略哪些短路的服务器，并选择并发数较低的服务器。
     * 6、RandomRule：随机选择一个可用的服务器。
     * 7、Retry：重试机制的选择逻辑
     * @return
     */
    @Bean
    public IRule iRule() {
        return new RoundRobinRule();
    }
}
