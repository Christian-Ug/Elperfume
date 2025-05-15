package com.perfulandia.perfulandia.service;

import com.perfulandia.perfulandia.model.Producto;
import com.perfulandia.perfulandia.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class ProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    public List<Producto>findAll(){return productosRepository.findAll();}
    public Producto findByIdP(Long id){return productosRepository.findById(id).get();}


}
