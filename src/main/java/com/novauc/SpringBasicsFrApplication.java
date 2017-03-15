package com.novauc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBasicsFrApplication {

	public static void main(String[] args) throws SQLException{
		Database database = Database.getInstance();
		database.createTables();
		SpringApplication.run(SpringBasicsFrApplication.class, args);
	}
}
