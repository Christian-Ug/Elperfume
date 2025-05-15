package com.perfulandia.perfulandia.repository;

import com.perfulandia.perfulandia.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface VentasRespository extends JpaRepository<Venta, Long> {
    List<Venta>findByIdV(String IdV);

    List<Venta>findByNumTarjera(String numTarjeta);



}
