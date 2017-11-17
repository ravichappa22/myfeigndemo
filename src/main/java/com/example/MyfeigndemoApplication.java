package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.example.service.FeignInterface;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = FeignInterface.class)
public class MyfeigndemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfeigndemoApplication.class, args);
	}
}
