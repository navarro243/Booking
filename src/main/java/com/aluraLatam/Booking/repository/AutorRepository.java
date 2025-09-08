package com.aluraLatam.Booking.repository;

import com.aluraLatam.Booking.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT s FROM Autor s " +
            "WHERE s.fechaMuerte >= :anoABuscar " +
            "AND s.fechaNacimiento < :anoABuscar")
    List<Autor> listarAutoresPorAno(@Param("anoABuscar") Integer anoABuscar);
}

