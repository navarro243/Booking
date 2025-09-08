package com.aluraLatam.Booking.controller;

import com.aluraLatam.Booking.dto.LibroDTO;
import com.aluraLatam.Booking.repository.LibroRepository;
import com.aluraLatam.Booking.service.Libro.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LibroController {

    @Autowired
    public LibroService service;

    @Autowired
    public LibroController(LibroService service) {
        this.service = service;
    }



    public LibroDTO buscarLibroWeb(String nombreLibro){

        return service.buscarLibroWeb(nombreLibro);
    }

    public List<LibroDTO> listarLibros(){
        return service.listarLibros();
    }








}
