package com.example.productos_api_spring_boot.services;

import com.example.productos_api_spring_boot.models.Categoria;
import com.example.productos_api_spring_boot.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase contiene la lógica de negocio (capa service)
public class CategoriaService {

    @Autowired // Inyección automática del repositorio que accede a la base de datos
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por su id
    public Categoria getById(int id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    // Crear una nueva categoría
    public Categoria add(Categoria categoria) {
        if (categoriaRepository.existsById(categoria.getCodigo())) {
            return null;
        }
        return categoriaRepository.save(categoria);
    }

    // Eliminar una categoría por su id
    public Categoria delete(int id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id);
            return categoria.get();
        }
        return null;
    }
}
