package com.aluraLatam.Booking.model;


import com.aluraLatam.Booking.dto.AutorDTO;
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


    public Autor(List<AutorDTO> autorDatos) {
        if (autorDatos != null && !autorDatos.isEmpty()) {
            AutorDTO firstAutor = autorDatos.get(0);
            this.fechaMuerte = firstAutor.fechaMuerte();
            this.fechaNacimiento = firstAutor.fechaNacimiento();
            this.nombreAutor = firstAutor.nombre();
        }
    }



    public Autor() {
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
