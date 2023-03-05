package com.gdschanyang.todayfeelingbackend2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TodayFeelingBackend2Application {

	public static void main(String[] args) {
		SpringApplication.run(TodayFeelingBackend2Application.class, args);
	}

}
