package com.ricky.j.platform.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Api(tags = {"示例控制器"})
@Slf4j
public class DemoController {

    @ApiOperation("示例方法")
    @RequestMapping(value = "/request",method = RequestMethod.GET)
    public String demoRequest(){
        log.info("This is the demo request!");
        return "Hello Controller!";
    }

}
