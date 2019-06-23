package com.chenguo.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/***************************************************************************
 * @Description - Feign中自带断路器HiHystric jar,只需fallback即可，但所有接口都必须错误处理
 *
 * @author chenguo 2019年06月22日
 * @version 1.0
 **************************************************************************/
@FeignClient(value="service-hi")
public interface ScheduleServiceHi {

    @GetMapping("hi")
    String sayHiFromEurekaClient(@RequestParam String name);
}
