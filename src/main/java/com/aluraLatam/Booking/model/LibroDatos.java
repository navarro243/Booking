package com.aluraLatam.Booking.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDatos(

        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorDatos> autores,
        @JsonAlias("languages") List<String> lenguajes,
        @JsonAlias("download_count") Long numeroDeDescargas


) {

}
