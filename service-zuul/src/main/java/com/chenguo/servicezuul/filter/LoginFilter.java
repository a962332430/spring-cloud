package com.chenguo.servicezuul.filter;

import cn.hutool.core.util.StrUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/***************************************************************************
 * @Description - 配置zuul过滤器
 *
 * @author chenguo 2019年06月23日
 * @version 1.0
 **************************************************************************/
@Component
@Slf4j
public class LoginFilter extends ZuulFilter {

    /** zuul四种不同生命周期的过滤器类型（pre:路由之前；routing:路由之时；post:路由之后；error:发送错误时调用）*/
    @Override
    public String filterType() {
        return "pre";
    }

    /** 多个过滤器时的顺序*/
    @Override
    public int filterOrder() {
        return 0;
    }

    /** 逻辑判断，何时过滤。这里直接true,表示永远过滤*/
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /** 过滤器的具体逻辑*/
    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s>>>%s",request.getMethod(), request.getRequestURL().toString()));

        String accessToken = request.getParameter("token");
        if(StrUtil.isEmpty(accessToken)){
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("token is empty!");
            }catch (Exception e){
                return null;
            }
            log.info("ok");
            return null;
        }


        return null;
    }
}
