package com.blueRibbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BlueRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueRibbonApplication.class, args);
	}
}
