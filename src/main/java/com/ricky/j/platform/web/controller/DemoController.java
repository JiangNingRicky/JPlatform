package com.ricky.j.platform.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/demo")
@Api(tags = {"示例控制器"})
@Slf4j
public class DemoController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @ApiOperation("示例方法")
    @RequestMapping(value = "/request",method = RequestMethod.GET)
    public String demoRequest(){
        log.info("This is the demo request!");
        return "Hello Controller!";
    }

    @ApiOperation("Redis测试")
    @GetMapping(value = "/redis/{key}/{value}")
    public String redisTest(@PathVariable String key,@PathVariable String value){

        redisTemplate.opsForValue().set(key,value);

        return redisTemplate.opsForValue().get(key).toString();
    }

    @ApiOperation("Kafka测试")
    @GetMapping(value = "/kafka/{topic}/{data}")
    public String kafkaTest(@PathVariable String topic,@PathVariable String data){

        kafkaTemplate.send(topic,data);

        return "kafka-OK";
    }

}
