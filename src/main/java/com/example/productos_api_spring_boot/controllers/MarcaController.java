package com.example.productos_api_spring_boot.controllers;

import com.example.productos_api_spring_boot.services.MarcaService;
import com.example.productos_api_spring_boot.models.Marca;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/v1/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> getAll() {
        return ResponseEntity.ok(marcaService.getAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> getById(@PathVariable int codigo) {
        Marca m = marcaService.getById(codigo);
        if (m != null) {
            return ResponseEntity.ok(m);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca no encontrada");
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Marca nuevaMarca) {
        Marca creada = marcaService.add(nuevaMarca);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<?> update(@PathVariable int codigo, @RequestBody Marca marca) {
        Marca actualizada = marcaService.update(codigo, marca);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca no encontrada");
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> delete(@PathVariable int codigo) {
        Marca eliminada = marcaService.delete(codigo);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca no encontrada");
    }
}
