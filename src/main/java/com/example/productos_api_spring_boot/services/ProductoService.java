package com.example.productos_api_spring_boot.services;

import com.example.productos_api_spring_boot.models.Producto;
import com.example.productos_api_spring_boot.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //  Indica que esta clase contiene la lógica de negocio (capa service)
public class ProductoService {

    @Autowired //  Inyección automática del repositorio que accede a la base de datos
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    // Obtener un producto por su código 
    public Producto getByCodigo(int codigo) {
        Optional<Producto> producto = productoRepository.findById(String.valueOf(codigo));
        return producto.orElse(null); // Devuelve el producto si existe, o null si no se encuentra
    }

    // Crear un nuevo producto
    public Producto add(Producto producto) {
        if (productoRepository.existsById(String.valueOf(producto.getCodigo()))) {
            return null;
        }
        return productoRepository.save(producto); 
    }

    // Actualizar un producto existente
    public Producto update(String codigo, Producto producto) {
        if (productoRepository.existsById(codigo)) {
            producto.setCodigo(Integer.parseInt(codigo)); 
            return productoRepository.save(producto); 
        }
        return null; 
    }

    // Eliminar un producto por su código
    public Producto delete(String codigo) {
        Optional<Producto> producto = productoRepository.findById(codigo);
        if (producto.isPresent()) {
            productoRepository.deleteById(codigo); 
            return producto.get(); 
        }
        return null; 
    }

    // Buscar productos por categoría
    public List<Producto> buscarPorCategoria(String nombre) {
        List<Producto> resultado = productoRepository.findByCategoriaIgnoreCase(nombre);
        if (resultado.isEmpty()) {
            return null; 
        }
        return resultado;
    }
}
