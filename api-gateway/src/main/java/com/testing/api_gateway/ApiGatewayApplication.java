package com.testing.api_gateway;

import com.testing.api_gateway.config.DotenvInitializer;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ApiGatewayApplication.class);
		app.addInitializers(new DotenvInitializer());
		app.run(args);
	}
}