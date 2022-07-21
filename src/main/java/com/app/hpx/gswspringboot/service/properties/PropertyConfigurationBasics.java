package com.app.hpx.gswspringboot.service.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * FIXME: Not Working!
 */
@PropertySource("classpath:custom.properties")
@ConfigurationProperties(prefix = "app")
@Configuration
public class PropertyConfigurationBasics {

    private String task;
    private String name;

    @Override
    public String toString() {
        return "PropertyConfigurationBasics [name=" + name + ", task=" + task + "]";
    }

}