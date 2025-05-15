package com.perfulandia.perfulandia.repository;

import com.perfulandia.perfulandia.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductosRepository extends JpaRepository<Producto , Long> {
    List<Producto> findBydescripcion (String descripcion);

}
