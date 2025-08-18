package com.aluraLatam.Booking;

import com.aluraLatam.Booking.model.LibroDatos;
import com.aluraLatam.Booking.principal.Principal;
import com.aluraLatam.Booking.service.ConsumoAPi;
import com.aluraLatam.Booking.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingApplication implements CommandLineRunner {

	private Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		principal.mostraMenu();


	}
}

