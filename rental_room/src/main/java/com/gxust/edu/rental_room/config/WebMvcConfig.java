package com.gxust.edu.rental_room.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 解决跨域请求的问题
     * allowedOrigins：允许哪些源网站访问
     * allowCredentials：是否浏览器应该发送credentials，例如cookies Access-Control-Allow-Credentials
     * allowedMethods：允许何种方式访问
     * maxAge：设置等待时间
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }
}
