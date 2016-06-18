package me.mingxing5212.chaihens.voucher.configure;

import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Sitemesh配置
 *
 * @author Mingxing Li
 * @date 19/2/16
 */
@Configuration
public class SitemeshConfiguration {

    @Bean
    public FilterRegistrationBean configurableSiteMeshFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ConfigurableSiteMeshFilter());
        EnumSet<DispatcherType> sitemeshDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        registration.setDispatcherTypes(sitemeshDispatcherTypes);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("*.jsp");
        registration.setUrlPatterns(urlPatterns);
        return registration;
    }
}
