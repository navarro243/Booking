package com.aluraLatam.Booking;

import com.aluraLatam.Booking.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingApplication implements CommandLineRunner {

	public Principal principal;


	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	@Autowired
	public BookingApplication(Principal principal) {
		this.principal = principal;
	}


	@Override
	public void run(String... args) throws Exception {

		principal.mostraMenu();


	}
}

