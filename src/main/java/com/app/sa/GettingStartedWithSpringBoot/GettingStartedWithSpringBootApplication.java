
package com.app.sa.GettingStartedWithSpringBoot;

import com.app.sa.GettingStartedWithSpringBoot.properties.PropertiesBasics;
import com.app.sa.GettingStartedWithSpringBoot.properties.PropertyConfigurationBasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GettingStartedWithSpringBootApplication implements CommandLineRunner {

        Logger logger = LoggerFactory.getLogger(this.getClass());

        // Reading port value from default properties //
        @Value("${server.port}")
        int port;

        @Autowired
        PropertiesBasics properties;

        @Autowired
        PropertyConfigurationBasics propertyConfigurationBasics;

        public static void main(String[] args) {
                SpringApplication.run(GettingStartedWithSpringBootApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
                // Accessing the property directly //
                logger.info("port Used is -> {}", port);

                // Accessing custom properties //
                logger.info("Basics of Properties -> {}", properties);

                // Accessing custom properties via config //
                logger.warn("Reading Custom Properties via Configurations -> {}", propertyConfigurationBasics);
        }
}
