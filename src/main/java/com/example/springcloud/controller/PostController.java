package com.example.springcloud.controller;


import com.example.springcloud.domain.Post;
import com.example.springcloud.feignclient.PostClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostClient postClient;

    @PostMapping("/feign/{id}")
    public Post feignTest(@PathVariable Long id) {
        log.info("### feignTest가 시작됨 ###");
        Post post = postClient.findById(id);
        log.info("Feign을 이용한 호출 결과 : " + post.toString());
        return post;
    }

    @PostMapping("/restTemplate/{id}")
    public Post restTemplate(@PathVariable Long id) {
        log.info("### restTemplate 시작됨 ###");
        RestTemplate restTemplate = new RestTemplate();
        Post post = restTemplate.getForObject("http://localhost:8080/bapi/posts/" + id,  Post.class);
        log.info("RestTemplate을 이용한 호출 결과 : " + post.toString());
        return post;
    }

    @GetMapping("/bapi/posts/{id}")
    public Post getPostId(@PathVariable("id") long id, @RequestHeader(value = "header") String header) {
        log.info("### getPostId 시작됨 ###");
        log.info("### getPostId header: {}", header);
        Post post = new Post();
        post.setContents("내용");
        post.setId(id);
        post.setTitle("제목");
        return post;
    }
}
