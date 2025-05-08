package umc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.repository.CoffeeRepository;
import umc.spring.entity.Coffee;


@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner testDbConnection(CoffeeRepository coffeeRepository) {
//		return args -> {
//
//			coffeeRepository.save(new Coffee("latte", "라떼"));
//
//			System.out.println("☕️ 커피 개수: " + coffeeRepository.count());
//		};
//	}
}