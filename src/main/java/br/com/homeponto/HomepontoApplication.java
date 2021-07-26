package br.com.homeponto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class HomepontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomepontoApplication.class, args);
	}

}
