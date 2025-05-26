package com.example.productos_api_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    private int codigo;
    private String nombre;
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;


}