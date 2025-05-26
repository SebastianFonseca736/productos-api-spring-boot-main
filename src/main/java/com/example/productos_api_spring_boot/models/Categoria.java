package com.example.productos_api_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    private int codigo;
    private String categoria;

    @OneToMany
    @JoinColumn(name = "codigo_productos", referencedColumnName = "id")
    private Producto productos;

}
