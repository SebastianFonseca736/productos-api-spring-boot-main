package com.example.productos_api_spring_boot.controllers;

import com.example.productos_api_spring_boot.services.ProductoService;
import com.example.productos_api_spring_boot.models.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

//import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")

// public class ProductoController {
    
    
//     private final ArrayList<Producto> productos;

//     public ProductoController() {
//         productos = new ArrayList<>();
//         //            código  nombre    precio  categoría
//         productos.add(new Producto("1", "Channel",   "Parfum", 1200));
//         productos.add(new Producto("2", "Boss",  "Eau de Parfum", 900));
//         productos.add(new Producto("3", "Sauvage",  "Eau de Parfum", 1000));

//     }

//     // GET: todos
//     @GetMapping
//     public ResponseEntity<List<Producto>> getAll() {
//         return ResponseEntity.ok(productos);
//     }

//     // GET: por código
//     @GetMapping("/{codigo}")
//     public ResponseEntity<?> getByCodigo(@PathVariable String codigo) {
//         for (Producto producto : productos) {
//             if (producto.getCodigo().equalsIgnoreCase(codigo)) {
//                 return ResponseEntity.ok(producto);
//             }
//         }
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
//     }

//      // GET: por categoría
//     @GetMapping("/categoria/{nombre}")
//     public ResponseEntity<List<Producto>> getByCategoria(@PathVariable String nombre) {
//         List<Producto> resultado = new ArrayList<>();
//         for (Producto producto : productos) {
//             if (producto.getCategoria().equalsIgnoreCase(nombre)) {
//                 resultado.add(producto);
//             }
//         }

//         if (resultado.isEmpty()) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
//         }

//         return ResponseEntity.ok(resultado);
//     }

//     // POST: agregar
//     @PostMapping
//     public ResponseEntity<?> add(@RequestBody Producto nuevoProducto) {
//         for (Producto p : productos) {
//             if (p.getCodigo().equalsIgnoreCase(nuevoProducto.getCodigo())) {
//                 return ResponseEntity.status(HttpStatus.CONFLICT)
//                                      .body("Ya existe un producto con ese código");
//             }
//         }
//         productos.add(nuevoProducto);
//         return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
//     }

// }


public class ProductoController {

    @Autowired // Inyecta el servicio
    private ProductoService productoService;

    // GET /api/v1/productos 
    // Devuelve todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        return ResponseEntity.ok(productoService.getAll());
    }

    // GET /api/v1/productos/{codigo}
    //Busca un producto por código
    @GetMapping("/{codigo}")
    public ResponseEntity<?> getByCodigo(@PathVariable String codigo) {
        Producto p = productoService.getByCodigo(codigo);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }

    // GET /api/v1/productos/categoria/{nombre} → Busca productos por categoría
    @GetMapping("/categoria/{nombre}")
    public ResponseEntity<List<Producto>> getByCategoria(@PathVariable String nombre) {
        List<Producto> productos = productoService.buscarPorCategoria(nombre);
        return ResponseEntity.ok(productos);
    }

    // POST /api/v1/productos → Crea un nuevo producto
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Producto nuevoProducto) {
        Producto creado = productoService.add(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}

