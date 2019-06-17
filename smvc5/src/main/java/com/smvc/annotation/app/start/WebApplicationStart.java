package com.smvc.annotation.app.start;

import com.smvc.annotation.app.config.RootConfig;
import com.smvc.annotation.app.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author tk
 * @date 2019/6/11 23:46
 * @desc
 */
public class WebApplicationStart extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 配置拦截的映射"/" 拦截所有请求，包括静态资源，但不包括jsp
     *              "/*"拦截所有请求，包括静态资源，包括jsp
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


}
