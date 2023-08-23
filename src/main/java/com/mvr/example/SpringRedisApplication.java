package com.mvr.example;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Point;

import com.mvr.example.models.Address;
import com.mvr.example.models.Person;
import com.mvr.example.models.repositories.PeopleRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableRedisDocumentRepositories(basePackages = "com.mvr.example.*")
@EnableSwagger2
@SpringBootApplication
public class SpringRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build();
	}

	@Bean
	CommandLineRunner loadTestData(PeopleRepository repo) {
		return args -> {
			repo.deleteAll();
			String thorSays = "The Rabbit Is Correct, And Clearly The Smartest One Among You";

			Address thorsAddress = Address.of("248", "Seven Mile Beach Rd", "Broken Head", "NSW", "2481", "Australia");

			Person thor = Person.of("Chris", "Hemsworth", 38, thorSays, new Point(153.616667, -28.716667), thorsAddress, Set.of("hammer", "biceps", "hair", "heart"));

			repo.save(thor);
		};
	}

}
