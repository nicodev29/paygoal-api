package com.example.crudpaygoal.service;
import com.example.crudpaygoal.models.Producto;

import java.util.List;

public interface IProductoServicio {

     List<Producto> listarProductos();

     void guardarProducto(Producto producto);

     Producto obtenerProductoPorId(Long id);

     Producto obtenerProductoPorNombre(String nombre);

     void eliminarProducto(Long id);

     void actualizarProducto(Long id, String nombre, String descripcion, Double precio, Integer cantidad);

     List<Producto> ordenarPorPrecio();

}
