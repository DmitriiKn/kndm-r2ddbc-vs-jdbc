package ru.kndm.jdbc;

import org.springframework.boot.SpringApplication;

public class TestJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.from(JdbcApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
