package com.aluraLatam.Booking.service.Libro;

import com.aluraLatam.Booking.dto.AutorDTO;
import com.aluraLatam.Booking.dto.LibroDTO;
import com.aluraLatam.Booking.model.ApiResult;
import com.aluraLatam.Booking.model.Autor;
import com.aluraLatam.Booking.model.Libro;
import com.aluraLatam.Booking.repository.AutorRepository;
import com.aluraLatam.Booking.repository.LibroRepository;
import com.aluraLatam.Booking.service.ConsumoAPi;
import com.aluraLatam.Booking.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LibroService {
    private final String URL_BASE = "https://gutendex.com/books?search=";
    private ConsumoAPi consumoAPI = new ConsumoAPi();
    private ConvierteDatos convertir = new ConvierteDatos();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;




    @Autowired
    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }




    @Transactional
    public LibroDTO buscarLibroWeb(String nombreLibro){

        var json = consumoAPI.obtenerDatos(URL_BASE+nombreLibro.replace(" ", "%20"));
        if (!json.isEmpty()){
            ApiResult respuesta = convertir.obtenerDatos(json, ApiResult.class);
            Libro libroBuscado = new Libro(respuesta.respuestaApi().get(0));
            guardarAutores(libroBuscado.getAutores());
            libroRepository.save(libroBuscado);

            libroBuscado.getAutores().forEach(System.out::println);

            return respuesta.respuestaApi().get(0);
        }
        return null;
    }

    @Transactional
    private void guardarAutores(List<Autor> autor){
        autor.forEach(s -> autorRepository.save(s));
    };

    public List<LibroDTO> listarLibros(){

        List<Libro> librosAlmacenados = libroRepository.findAll();

        return convertir.ConvertirLibro(librosAlmacenados);

    }

//    private List<LibroDTO> ConvertirLibro( List<Libro> libro ){
//        return libro.stream()
//                .map(s -> new LibroDTO(s.getTitulo(), ConvertirAutor(s.getAutores()), s.getLenguajes(), s.getNumeroDeDescargas()))
//                .collect(Collectors.toUnmodifiableList());
//    }
//
//    private List<AutorDTO> ConvertirAutor(List<Autor> autor){
//        return autor.stream()
//                .map(s -> new AutorDTO(s.getNombreAutor(), s.getFechaNacimiento(), s.getFechaMuerte()))
//                .collect(Collectors.toUnmodifiableList());
//    }




}
