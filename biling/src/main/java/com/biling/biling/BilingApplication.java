package com.biling.biling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients//==> bech n5adim openFeign
public class BilingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BilingApplication.class, args);
	}

}
