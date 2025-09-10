package com.aluraLatam.Booking.service.Libro;

import com.aluraLatam.Booking.dto.AutorDTO;
import com.aluraLatam.Booking.model.Autor;
import com.aluraLatam.Booking.model.Libro;
import com.aluraLatam.Booking.repository.AutorRepository;
import com.aluraLatam.Booking.repository.LibroRepository;
import com.aluraLatam.Booking.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private ConvierteDatos convertir = new ConvierteDatos();
    @Autowired
    private AutorRepository autorRepository;





    public List<AutorDTO> listarAutores(){
        List<Autor> autores = autorRepository.findAll();
        return convertir.ConvertirAutor(autores);
    }

    public List<AutorDTO> listarAutoresPorAno(Integer anoABuscar){
        List<Autor> autores = autorRepository.listarAutoresPorAno(anoABuscar);


        return convertir.ConvertirAutor(autores);
    }

}
