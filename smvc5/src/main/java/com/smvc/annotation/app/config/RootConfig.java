package com.smvc.annotation.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author tk
 * @date 2019/6/11 23:45
 * @desc
 */
@Configuration
@ComponentScan(value = {"com.smvc.annotation.components.root"})
public class RootConfig {
}
