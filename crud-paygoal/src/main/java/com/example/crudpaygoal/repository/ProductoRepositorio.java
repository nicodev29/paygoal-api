package com.example.crudpaygoal.repository;

import com.example.crudpaygoal.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    Producto findByNombre(String nombre);

}
