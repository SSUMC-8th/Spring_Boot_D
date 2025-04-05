package umc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;


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

}
