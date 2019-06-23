package com.chenguo.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***************************************************************************
 * @Description - 测试
 *
 * @author chenguo 2019年06月22日
 * @version 1.0
 **************************************************************************/
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("hi")
    public String sayHi(@RequestParam String name){
        return "hi " + name + ", I am from port: " + port;
    }
}
