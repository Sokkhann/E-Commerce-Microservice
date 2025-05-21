package com.testing.api_gateway;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class TestController {
    private DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public String testDiscovery() {
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        return instances.isEmpty() ? "No user-service found!" : instances.get(0).getUri().toString();
    }
}