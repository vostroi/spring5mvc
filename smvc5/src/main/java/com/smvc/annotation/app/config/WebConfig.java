package com.smvc.annotation.app.config;

import com.smvc.annotation.components.web.interceptor.GlobalInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author tk
 * @date 2019/6/11 23:48
 * @desc @EnableWebMvc 开启springmvc高级定制功能 也可以单独写一个配置类用@EnableWebMvc来注解
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = {"com.smvc.annotation.components.web.controller"})
public class WebConfig implements WebMvcConfigurer {

    /**
     * 配置视图解析器
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 等同于下面方法
        registry.jsp();
//        registry.jsp("/WEB-INF/", ".jsp");
    }

    /**
     * 配置处理静态资源
     * 需要在WEB-INF同级目录中新建resources文件夹来存放静态资源文件
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // "/**" 表示拦截所有层级的请求
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LocaleChangeInterceptor());
        // 权限的拦截器等...
    }

    /**
     * 配置异步支持
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    /**
     * 配置跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }
}
