package io.swagger.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2015-11-16T10:43:27.803Z")
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
