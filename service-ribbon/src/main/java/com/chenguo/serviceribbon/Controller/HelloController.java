package com.chenguo.serviceribbon.Controller;

import com.chenguo.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***************************************************************************
 * @Description - TODO
 *
 * @author chenguo 2019年06月22日
 * @version 1.0
 **************************************************************************/
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("hi-ribbon")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
