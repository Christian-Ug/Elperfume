package com.perfulandia.perfulandia.service;


import com.perfulandia.perfulandia.model.Venta;
import com.perfulandia.perfulandia.repository.VentasRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VentasService {

    @Autowired
    private VentasRespository ventasRespository;

    public List<Venta> findAll(){return ventasRespository.findAll();}
    public Venta findById(Long idV){return ventasRespository.findById(idV).get();}
    public Venta save (Venta venta){return ventasRespository.save(venta);}
    public void delete (Long idV){ventasRespository.deleteById(idV);}

}
