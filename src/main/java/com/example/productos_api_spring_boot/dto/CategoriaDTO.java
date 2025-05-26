package com.example.productos_api_spring_boot.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriaDTO {

    private int codigo;          // categoriacodigo
    private String nombre;       // categoriacnombre
}
