package com.aluraLatam.Booking.controller;


import com.aluraLatam.Booking.dto.AutorDTO;
import com.aluraLatam.Booking.service.Libro.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutorController {


    @Autowired
    public AutorService service;

    @Autowired
    public AutorController(AutorService autorService){
        this.service = autorService;
    }

    public List<AutorDTO> listarAutores(){
        return  service.listarAutores();
    }

    public List<AutorDTO> listarAutoresPorAno(Integer anoABuscar){

        return service.listarAutoresPorAno(anoABuscar);
    }

}
