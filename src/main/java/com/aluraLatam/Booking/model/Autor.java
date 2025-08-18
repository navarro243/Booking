package com.aluraLatam.Booking.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nombreAutor;
    private Integer fechaNacimiento;
    private Integer fechaMuerte;


    public Autor(List<AutorDatos> autorDatos) {
        autorDatos.stream()
                .map(e -> new Autor(e));
    }
    public Autor(AutorDatos autorDatos){
        this.fechaMuerte = autorDatos.fechaMuerte();
        this.fechaNacimiento = autorDatos.fechaNacimiento();
        this.nombreAutor = autorDatos.nombre();
    }



    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(Integer fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }


}
