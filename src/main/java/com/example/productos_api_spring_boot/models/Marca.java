package com.example.productos_api_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "marca")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Marca {

    @Id
    private int codigo;
    private String marca;

    @OneToMany
    @JoinColumn(name = "codigo_productos", referencedColumnName = "id")
    private Producto productos;
}
