package com.maps.Dijkstra_maven_Backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DijkstraMavenBackendApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(DijkstraMavenBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application executed!");
	}
}

