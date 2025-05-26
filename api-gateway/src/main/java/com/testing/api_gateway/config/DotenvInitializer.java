package com.testing.api_gateway.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * it not automatically load the value in .env file so we need this to support
 * first add dependency
 * and that make this config file
 */

public class DotenvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        Dotenv dotenv = Dotenv.configure()
                .directory("./") // Looks for .env in root
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        Map<String, Object> props = new HashMap<>();
        dotenv.entries().forEach(entry -> props.put(entry.getKey(), entry.getValue()));

        ConfigurableEnvironment env = context.getEnvironment();
        env.getPropertySources().addFirst(new MapPropertySource("dotenv", props));
    }
}
