package com.example.productos_api_spring_boot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String nombre;
    @JsonIgnore

    @OneToMany(mappedBy = "marca")
    private List<Producto> productos;
}
