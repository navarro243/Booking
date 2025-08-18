package com.aluraLatam.Booking.dto;

import com.aluraLatam.Booking.model.Libro;
import com.aluraLatam.Booking.model.LibroDatos;

import java.util.List;
import java.util.stream.Collectors;

public record LibroDTO(
        String nombreLibro,
        List<String> nombreAutor,
        List<String> idiomas,
        long numeroDescargas
) {
    public LibroDTO(Libro libroInfo){
        this(
                libroInfo.getTitulo(),
                libroInfo.getAutores().stream()
                        .map(e -> e.getNombreAutor())
                        .collect(Collectors.toUnmodifiableList()),
                libroInfo.getLenguajes(),
                libroInfo.getNumeroDeDescargas()
        );
    }



}
