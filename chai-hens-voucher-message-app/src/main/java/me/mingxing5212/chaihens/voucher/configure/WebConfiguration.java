package me.mingxing5212.chaihens.voucher.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@EnableConfigurationProperties(WebConfigurationProperties.class)
public class WebConfiguration {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private WebConfigurationProperties properties;

    @Bean
    public DispatcherServlet dispatcherServlet() {
        DispatcherServlet servlet = new DispatcherServlet();
        servlet.setThrowExceptionIfNoHandlerFound(true);
        return servlet;
    }
}
