package com.aluraLatam.Booking.repository;

import com.aluraLatam.Booking.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Long> {
}
