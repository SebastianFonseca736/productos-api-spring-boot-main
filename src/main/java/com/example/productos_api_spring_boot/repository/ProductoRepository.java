package com.example.productos_api_spring_boot.repository;

import com.example.productos_api_spring_boot.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
