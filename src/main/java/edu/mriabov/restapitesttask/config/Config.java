package edu.mriabov.restapitesttask.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@Setter
@PropertySource("application.properties")
@ConfigurationProperties(prefix = "user-registry")
public class Config {

    private int age;
}
