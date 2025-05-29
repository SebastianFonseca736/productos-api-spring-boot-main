package com.example.productos_api_spring_boot.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


// PRUEBA CON SERVICES 

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    private String nombre;
    private String descripcion;
    private int precio;
    private String categoria;

    @OneToMany(mappedBy = "producto")
    private List<Marca> marcas;
}

