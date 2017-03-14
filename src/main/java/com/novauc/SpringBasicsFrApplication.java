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
		Database database = Database.getInstance();
		database.createTables();
		SpringApplication.run(SpringBasicsFrApplication.class, args);
	}
}
