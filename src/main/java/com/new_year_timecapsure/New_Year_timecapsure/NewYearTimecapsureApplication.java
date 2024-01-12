package com.new_year_timecapsure.New_Year_timecapsure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NewYearTimecapsureApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewYearTimecapsureApplication.class, args);
	}

}
