package com.aluraLatam.Booking.model;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;

    @ManyToMany
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

    private List<String> lenguajes;
    private Long numeroDeDescargas;

    public Libro(List<LibroDatos> libroDatos) {
        libroDatos.stream()
                .map(e -> new Libro(e));
    }

    public Libro(LibroDatos libroDatos) {
        this.titulo = libroDatos.titulo();
        this.autores = Collections.singletonList(new Autor(libroDatos.autores()));
        this.lenguajes = libroDatos.lenguajes();
        this.numeroDeDescargas = libroDatos.numeroDeDescargas();
    }

//    public libro(){}


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public Long getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Long numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
