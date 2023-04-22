package com.example.crudpaygoal.service;

import com.example.crudpaygoal.models.Producto;
import com.example.crudpaygoal.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }
    @Override
    public List<Producto> listarProductos() {
        List <Producto> productos = productoRepositorio.findAll();
        return productos;
    }
    @Override
    public void guardarProducto(Producto producto) {
        productoRepositorio.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        Producto producto = productoRepositorio.findById(id).orElse(null);
        return producto;
    }
    @Override
    public Producto obtenerProductoPorNombre(String nombre) {
        Producto producto = productoRepositorio.findByNombre(nombre);
        return producto;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }

    public void actualizarProducto(Long id, String nombre, String descripcion, Double precio, Integer cantidad) {

        Producto producto = this.obtenerProductoPorId(id);

        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);

        this.guardarProducto(producto);

    }
    @Override
    public List<Producto> ordenarPorPrecio() {
        List<Producto> productos = productoRepositorio.findAll();
        productos.sort(Comparator.comparing(Producto::getPrecio).reversed());
        return productos;
    }

}
