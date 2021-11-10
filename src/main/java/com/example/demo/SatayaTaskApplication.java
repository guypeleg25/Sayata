package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class SatayaTaskApplication {


	public static void main(String[] args) {

		System.out.println("Spring Boot is started");
		SpringApplication.run(SatayaTaskApplication.class, args);


	}
}

