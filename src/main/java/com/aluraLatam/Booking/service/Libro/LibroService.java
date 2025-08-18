package com.aluraLatam.Booking.service.Libro;

import com.aluraLatam.Booking.dto.LibroDTO;
import com.aluraLatam.Booking.model.ApiResult;
import com.aluraLatam.Booking.model.Libro;
import com.aluraLatam.Booking.model.LibroDatos;
import com.aluraLatam.Booking.repository.LibroRepository;
import com.aluraLatam.Booking.service.ConsumoAPi;
import com.aluraLatam.Booking.service.ConvierteDatos;
import org.springframework.stereotype.Service;


@Service
public class LibroService {
    private final String URL_BASE = "https://gutendex.com/books?search=";
    private ConsumoAPi consumoAPI = new ConsumoAPi();
    private ConvierteDatos convertir = new ConvierteDatos();
    private LibroRepository repository;



    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public LibroDTO buscarserieWeb(String nombreLibro){

        var json = consumoAPI.obtenerDatos(URL_BASE+nombreLibro.replace(" ", "%20"));
        ApiResult respuesta = convertir.obtenerDatos(json, ApiResult.class);
        Libro libroBuscado = new Libro(respuesta.respuestaApi());
        repository.save(libroBuscado);
        LibroDTO libroDatos = new LibroDTO(libroBuscado);
        return libroDatos;

    }
    public String mensaje(){
        return "Algo-----------------------";
    }

}
