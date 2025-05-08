package umc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

import org.springframework.context.ApplicationContext;
import umc.spring.service.RestaurantService.RestaurantQueryService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// DB 연결 상태 확인용 코드
	@Bean
	public CommandLineRunner demo(DataSource dataSource) {
		return args -> {
			try (Connection conn = dataSource.getConnection()) {
				System.out.println("[test] DB connection success: " + conn.getMetaData().getURL());
			} catch (Exception e) {
				System.out.println("[test] DB connection failed: " + e.getMessage());
			}
		};
	}

	// QueryDSL 테스트용 Runner
	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			RestaurantQueryService restaurantService = context.getBean(RestaurantQueryService.class);

			// 파라미터 값
			String name = "요아정";
			Float rating = 4.0f;

			System.out.println("🔍 findRestaurantsByNameAndRating 실행:");
			System.out.println("restaurantName: " + name);
			System.out.println("rating >= " + rating);

			restaurantService.findRestaurantsByNameAndRating(name, rating).forEach(System.out::println);
		};
	}
}
