
package com.app.sa.GettingStartedWithSpringBoot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:custom.properties")
public class PropertiesBasics {

    @Value("${app.mode.name}")
    private String mode;

    @Value("${app.mode.task}")
    private String task;

    @Override
    public String toString() {
        return "PropertiesConfiguration [mode=" + mode + ", task=" + task + "]";
    }

}
