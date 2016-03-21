package com.prodyna.mfs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.prodyna.mfs.repositories.CarRepository;
import com.prodyna.mfs.repositories.VendorRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Bean
	public CommandLineRunner init(final CarRepository carRepo, final VendorRepository vendorRepo) {

		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {

				// Init MockData
				MockService mockService = new MockService(carRepo, vendorRepo);
				mockService.init();
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
