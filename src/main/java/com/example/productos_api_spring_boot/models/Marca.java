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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    private String nombre;
    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "codigo_productos", nullable = false)
    private Producto producto;   
    }
