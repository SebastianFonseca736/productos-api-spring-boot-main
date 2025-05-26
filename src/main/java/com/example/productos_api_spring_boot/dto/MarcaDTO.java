package com.example.productos_api_spring_boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarcaDTO {
    private int codigo;          // marcaid
    private String nombre;       // marcanombre
}
