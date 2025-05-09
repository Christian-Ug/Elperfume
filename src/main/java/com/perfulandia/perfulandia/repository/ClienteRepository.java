package com.perfulandia.perfulandia.repository;

import com.perfulandia.perfulandia.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByApellido (String apellido);

    Cliente findBycorreoElectronico (String correoElectronico);

    Cliente findByNombreAndApellido(String nombre, String apellido);



}
