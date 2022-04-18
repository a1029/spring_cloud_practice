package com.example.springcloud.domain;

import lombok.Data;

@Data
public class Post {

    private long id;
    private String title;
    private String contents;
}
