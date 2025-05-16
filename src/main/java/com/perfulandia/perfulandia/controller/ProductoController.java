package com.perfulandia.perfulandia.controller;

import com.perfulandia.perfulandia.model.Producto;
import com.perfulandia.perfulandia.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/producto")


public class ProductoController {

    @Autowired
    private ProductosService productosService;

    @GetMapping
    public ResponseEntity<Producto>listar(){
        List<Producto>productos=productosService.findAll();
        if (productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok((Producto) productos);
    }

    @PostMapping
    public ResponseEntity<Producto>guardar(@RequestBody Producto producto){
        Producto Newproducto = productosService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Newproducto);
    }

    @GetMapping("/{idP}")
    public ResponseEntity<Producto>buscar(@PathVariable Long id){
        try{
            Producto producto = productosService.findByIdP(id);
            return ResponseEntity.ok(producto);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto>actualizar(@PathVariable Long id, @RequestBody Producto producto){
        try{
            Producto pro= productosService.findByIdP(id);
            pro.setIdP(id);
            pro.setPrecio(producto.getPrecio());

            productosService.save(pro);
            return  ResponseEntity.ok(producto);
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            productosService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
