package com.example.crudpaygoal.controller;

import com.example.crudpaygoal.models.Producto;
import com.example.crudpaygoal.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/getAll")
    public List<Producto> listarProductos() {
        return productoServicio.listarProductos();
    }

    @GetMapping("/byId/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return productoServicio.obtenerProductoPorId(id);
    }

    @GetMapping("/byName/{nombre}")
    public Producto obtenerProductoPorNombre(@PathVariable String nombre) {
        return productoServicio.obtenerProductoPorNombre(nombre);
    }

    @PostMapping("/saveProduct")
    public void guardarProducto(@RequestBody Producto producto) {
        productoServicio.guardarProducto(producto);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoServicio.eliminarProducto(id);
    }

    @PutMapping("/update/{id}")
    public void actualizarProducto(@PathVariable Long id,
                                   @RequestParam String nombre,
                                   @RequestParam String descripcion,
                                   @RequestParam Double precio,
                                   @RequestParam Integer cantidad) {

        Producto producto = this.obtenerProductoPorId(id);

        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);

        this.guardarProducto(producto);

    }

    @GetMapping("/orderByPrice")
    public List<Producto> ordenarPorPrecio() {
        return productoServicio.ordenarPorPrecio();
    }

}
