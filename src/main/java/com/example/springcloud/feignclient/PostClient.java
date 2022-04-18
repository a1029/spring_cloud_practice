package com.example.springcloud.feignclient;

import com.example.springcloud.config.HeaderConfiguration;
import com.example.springcloud.domain.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "post-api", url = "localhost:8080/bapi", configuration = {HeaderConfiguration.class})
public interface PostClient {
    @GetMapping("/posts/{id}")
    Post findById(@PathVariable("id") Long id);
}
