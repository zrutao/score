package com.zrt.score.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    @GetMapping(value="/index")
    public String index(@RequestParam(value = "name",required = false,defaultValue = "未命名") String name)
    {
        return "你的姓名为："+name;
    }
}
