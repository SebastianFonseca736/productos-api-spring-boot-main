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
    private int codigo;
    private String nombre;
    private String descripcion;
    private int precio;

    @ManyToOne
    //private List<Marca> marcas; (hablar con el profe y descubrir que pasa) 
    private Marca marca;
    @ManyToOne
    //private List<Categoria> categoria;(hablar con el profe y descubrir que pasa) 
    private Categoria categoria;


   
}

