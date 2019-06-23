package com.chenguo.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.hystrix.FallbackHandler;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/***************************************************************************
 * @Description - ribbon中使用断路器。需引入Hystric jar，并使用注解调用错误处理方法
 *
 * @author chenguo 2019年06月22日
 * @version 1.0
 **************************************************************************/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    // 这里消费调用 Eureka-Client : SERVICE-HI 这个服务
    @HystrixCommand(fallbackMethod = "hiErrorHandle")
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiErrorHandle(String name){
        return "hi," + name + ", sorry for error!";
    }
}
