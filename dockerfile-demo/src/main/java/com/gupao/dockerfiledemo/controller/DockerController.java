package com.gupao.dockerfiledemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
    @GetMapping("/dockerfile")
    @ResponseBody
    String dockerfile() {
        return "hello docker" ;
    }
}
