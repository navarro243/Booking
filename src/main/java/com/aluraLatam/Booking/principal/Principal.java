package com.aluraLatam.Booking.principal;

import com.aluraLatam.Booking.controller.LibroController;
import com.aluraLatam.Booking.dto.LibroDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {


    private Scanner teclado = new Scanner(System.in);
    private final LibroController libroController;



    @Autowired
    public Principal(LibroController libroController){
        this.libroController = libroController;
    };

    public void mostraMenu(){

        int opc = 1;
        while (opc != 0) {
            System.out.println("""
                1)Buscar un libro Nuevo
                
                0)Salir
                """);
            try{
                opc = teclado.nextInt();
                teclado.nextLine();
            }catch (NumberFormatException e){
                System.out.println("el error es "+ e + " estrada: " +opc);
            }


            switch (opc) {
                case 1:
//                    buscarUnNuevoLibro();
                    System.out.println(mensaje());
                    break;

            }
        }

    }

    public void buscarUnNuevoLibro(){
         LibroDTO libroUsuario = getLibro();
        System.out.printf("""
                ------------------------
                Nombre Libro: %s
                Autor: %s
                Idiomas: %s
                Numero de descargas: %d
                
                """,  libroUsuario.nombreLibro(), libroUsuario.nombreAutor(),  libroUsuario.idiomas(), libroUsuario.numeroDescargas());

    }

    private LibroDTO getLibro(){
        System.out.println("Ingrese el nombre del libro");
        var nombreLibro = teclado.nextLine();

        LibroDTO respuesta = libroController.buscarserieWeb(nombreLibro);

        return respuesta;
    }

    private String mensaje(){
        return libroController.mensaje();
    }
}
