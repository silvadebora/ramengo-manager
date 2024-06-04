package com.redventures.ramengo.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.redventures.ramengo.admin")
public class RamenGoAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(RamenGoAdminApplication.class, args);
	}

}
