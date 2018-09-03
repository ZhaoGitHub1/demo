package com.yizhu;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
        System.out.println("开始退出上下文！！！");
		return () -> 10001;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("springboot版本信息："+SpringBootVersion.getVersion());
	}
}
