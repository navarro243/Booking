package com.aluraLatam.Booking.service;

import com.aluraLatam.Booking.dto.AutorDTO;
import com.aluraLatam.Booking.dto.LibroDTO;
import com.aluraLatam.Booking.model.Autor;
import com.aluraLatam.Booking.model.Libro;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();


//    Función que permite transformar un JSON en un objeto Java
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

//    Función que permite transformar un Libro en un LibroDTO
    public List<LibroDTO> ConvertirLibro(List<Libro> libro ){
        return libro.stream()
                .map(s -> new LibroDTO(s.getTitulo(), ConvertirAutor(s.getAutores()), s.getLenguajes(), s.getNumeroDeDescargas()))
                .collect(Collectors.toUnmodifiableList());
    }

    //    Función que permite transformar un Autor en un AutorDTO
    public List<AutorDTO> ConvertirAutor(List<Autor> autor){
        return autor.stream()
                .map(s -> new AutorDTO(s.getNombreAutor(), s.getFechaNacimiento(), s.getFechaMuerte()))
                .collect(Collectors.toUnmodifiableList());
    }

}
