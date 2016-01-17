package com.colitsys.feeplaza;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web application configuration.
 */
@Configuration
@EnableWebMvc
@EnableJpaRepositories
@Import({WebApplicationSecurityConfiguration.class, WebApplicationJpaConfiguration.class})
@ComponentScan
public class WebApplicationConfiguration extends WebMvcConfigurerAdapter {
    private static final Log log = LogFactory.getLog(WebApplicationConfiguration.class);

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        log.debug("Adding view controller");
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
