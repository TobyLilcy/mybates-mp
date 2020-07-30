package com.tts.lcy;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.ManagedBean;

@MapperScan("com.tts.lcy.mapper")
@SpringBootApplication
public class MybatisMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisMpApplication.class, args);
	}

}
