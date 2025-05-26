package com.example.productos_api_spring_boot.controllers;

import com.example.productos_api_spring_boot.services.CategoriaService;
import com.example.productos_api_spring_boot.models.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaService.getAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> getById(@PathVariable int codigo) {
        Categoria c = categoriaService.getById(codigo);
        if (c != null) {
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrada");
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Categoria nuevaCategoria) {
        Categoria creada = categoriaService.add(nuevaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<?> update(@PathVariable int codigo, @RequestBody Categoria categoria) {
        Categoria actualizada = categoriaService.update(codigo, categoria);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrada");
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> delete(@PathVariable int codigo) {
        Categoria eliminada = categoriaService.delete(codigo);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrada");
    }
}
