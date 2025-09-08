package com.aluraLatam.Booking.principal;

import com.aluraLatam.Booking.controller.AutorController;
import com.aluraLatam.Booking.controller.LibroController;
import com.aluraLatam.Booking.dto.AutorDTO;
import com.aluraLatam.Booking.dto.LibroDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal {


    private final Scanner teclado = new Scanner(System.in);
    public LibroController libroController;
    public AutorController autorController;

    @Autowired
    public Principal(LibroController libroController, AutorController autorController) {
        this.libroController = libroController;
        this.autorController = autorController;

    }



    public void mostraMenu(){

        int opc = 1;
        while (opc != 0) {
            System.out.println("""
                1)Buscar un libro Nuevo
                2)Listar todos los Libros buscados
                3)Listar Autores
                
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
                    buscarUnNuevoLibro();
                    break;

                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;

                case 0:
                    System.out.println("Gracias por su uso");
                    break;

                default:
                    System.out.println("Opcion no valida");
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
                
                """,  libroUsuario.titulo(), libroUsuario.autores(),  libroUsuario.lenguajes(), libroUsuario.numeroDeDescargas());

    }

    private LibroDTO getLibro(){
        System.out.println("Ingrese el nombre del libro");
        var nombreLibro = teclado.nextLine();

        return libroController.buscarLibroWeb(nombreLibro);

    }

    private void listarLibros(){

        List<LibroDTO> libros = libroController.listarLibros();

        libros.forEach(System.out::println);


    }

    private void listarAutores(){
        List<AutorDTO> autores = autorController.listarAutores();

        autores.forEach(System.out::println);

    }


}
