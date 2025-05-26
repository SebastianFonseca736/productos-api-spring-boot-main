package com.example.productos_api_spring_boot.repository;

import com.example.productos_api_spring_boot.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
