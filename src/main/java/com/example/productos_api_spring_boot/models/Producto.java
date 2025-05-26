package com.example.productos_api_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;
//import java.util.List;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor

// public class Producto {
//     private String codigo;
//     private String nombre;    
//     private String categoria;

//     private int precio;
// }


// PRUEBA CON SERVICES 

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    @Id
    private int codigo;
    private String nombre;
    private String descripcion;
    private int precio;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Marca> marcas;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Categoria> categorias;
    // @JsonIgnore
}

