package com.colitsys.feeplaza;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Web application configuration.
 */
@Configuration
@EnableWebMvc
@EnableJpaRepositories
@Import({WebApplicationSecurityConfiguration.class, WebApplicationJpaConfiguration.class})
@ComponentScan
public class WebApplicationConfiguration {
    // Empty class.
}
