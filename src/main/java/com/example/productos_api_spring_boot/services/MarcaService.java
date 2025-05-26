package com.example.productos_api_spring_boot.services;

import com.example.productos_api_spring_boot.models.Marca;
import com.example.productos_api_spring_boot.repository.MarcaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase contiene la lógica de negocio (capa service)
public class MarcaService {

    @Autowired // Inyección automática del repositorio que accede a la base de datos
    private MarcaRepository marcaRepository;

    // Obtener todas las marcas
    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    // Obtener una marca por su id
    public Marca getById(int id) {
        Optional<Marca> marca = marcaRepository.findById(id);
        return marca.orElse(null);
    }

    // Crear una nueva marca
    public Marca add(Marca marca) {
        if (marcaRepository.existsById(marca.getCodigo())) {
            return null;
        }
        return marcaRepository.save(marca);
    }

    
    // Actualizar una marca existente
    public Marca update(int codigo, Marca marca) {
        if (marcaRepository.existsById(codigo)) {
            marca.setCodigo(codigo);
            return marcaRepository.save(marca);
        }
        return null;
    }

    // Eliminar una marca por su id
    public Marca delete(int id) {
        Optional<Marca> marca = marcaRepository.findById(id);
        if (marca.isPresent()) {
            marcaRepository.deleteById(id);
            return marca.get();
        }
        return null;
    }
}
