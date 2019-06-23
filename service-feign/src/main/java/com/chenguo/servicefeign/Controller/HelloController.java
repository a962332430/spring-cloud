package com.chenguo.servicefeign.Controller;

import com.chenguo.servicefeign.service.ScheduleServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***************************************************************************
 * @Description - TODO
 *
 * @author chenguo 2019年06月22日
 * @version 1.0
 **************************************************************************/
@RestController
public class HelloController {

    @Autowired
    ScheduleServiceHi scheduleServiceHi;

    @GetMapping("hi-feign")
    public String sayHi(@RequestParam String name){
        return scheduleServiceHi.sayHiFromEurekaClient(name);
    }
}
