package com.tz.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope

@RestController
@SpringBootApplication
public class ConfigClientApplication {
    /**
     * 刷新配置，无需重启服务，post 请求
     * /actuator/bus-refresh接口可以指定服务，
     * 即使用"destination"参数，比如 “/actuator/bus-refresh?destination=customers:**”
     * 即刷新服务名为customers的所有服务。
     * http://localhost:8881/actuator/bus-refresh
     */

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
    @Value("${tz.name}")
    String name;
    @RequestMapping(value = "/hi")
    public String hi(){
        return name;
    }
}
