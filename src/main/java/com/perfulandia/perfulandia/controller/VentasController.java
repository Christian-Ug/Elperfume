package com.perfulandia.perfulandia.controller;

import com.perfulandia.perfulandia.model.Cliente;
import com.perfulandia.perfulandia.model.Venta;
import com.perfulandia.perfulandia.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")

public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping
    public ResponseEntity<Venta> listar() {
        List<Venta> venta = ventasService.findAll();
        if (venta.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok((Venta) venta);

    }
    @PostMapping
    public ResponseEntity<Venta> guardar(@RequestBody Venta venta) {
        Venta ventaNueva = ventasService.save(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaNueva);
    }

    @GetMapping("/{idV}")
    public ResponseEntity<Venta> buscar(@PathVariable Long idV){
        try{
            Venta venta = ventasService.findById(idV);
            return ResponseEntity.ok(venta);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/{idV}")
    public ResponseEntity<Venta> actualizar(@PathVariable Long idV, @RequestBody Venta venta){
        try{
            Venta ven = ventasService.findById(idV);
            ven.setIdV(idV);
            ven.setNumTarjeta(venta.getNumTarjeta());
            ven.setFechaCaducidad(venta.getFechaCaducidad());
            ven.setCvv(venta.getCvv());

            ventasService.save(ven);
            return ResponseEntity.ok(venta);
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{idV}")
    public ResponseEntity<?> cancelar(@PathVariable Long idV){
        try{
            ventasService.delete(idV);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
