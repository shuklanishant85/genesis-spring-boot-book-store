package com.genesis.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.genesis.store.repository")
@EntityScan("com.genesis.store.repository")
@SpringBootApplication
public class GenesisSpringBootBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenesisSpringBootBookStoreApplication.class, args);
	}

}
