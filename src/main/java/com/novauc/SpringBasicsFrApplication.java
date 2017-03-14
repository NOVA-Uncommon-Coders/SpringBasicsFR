package com.novauc;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class SpringBasicsFrApplication {

	public static void main(String[] args) throws SQLException{
		//Server.createWebServer().start();
		Connection connection = DriverManager.getConnection("jdbc:h2:./main");
		SpringApplication.run(SpringBasicsFrApplication.class, args);
	}
}
