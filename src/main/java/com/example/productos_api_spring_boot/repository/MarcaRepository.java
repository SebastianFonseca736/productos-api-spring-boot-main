package com.example.productos_api_spring_boot.repository;

import com.example.productos_api_spring_boot.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
