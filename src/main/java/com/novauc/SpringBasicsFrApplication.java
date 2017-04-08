package com.novauc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@SpringBootApplication
public class SpringBasicsFrApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBasicsFrApplication.class, args);
	}

}