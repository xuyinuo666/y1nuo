package com.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author y1nuo
 * @description
 * @date $ $
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "1111";
    }
}
