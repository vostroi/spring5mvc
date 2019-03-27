package com.java.vostroi.component.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author tk
 * @date 2019/3/24 15:03
 * @desc 自定义视图解析器 再配置此视图解析器
 * 如果要真实现自定义Excel的视力，可以直接实现AbstractXlsView类
 */
@Component
public class ExcelView implements View {

    @Override
    public String getContentType() {
        System.out.println("ExcelView " + new Date());
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().write("Hello this is Excel view date=" + new Date());

    }
}
