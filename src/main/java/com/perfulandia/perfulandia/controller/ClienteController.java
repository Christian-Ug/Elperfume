package com.perfulandia.perfulandia.controller;

import com.perfulandia.perfulandia.model.Cliente;
import com.perfulandia.perfulandia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Cliente> listar() {
        List<Cliente>cliente = clienteService.findAll();
        if (cliente.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok((Cliente) cliente);

    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@RequestBody  Cliente cliente) {
        Cliente productoNuevo = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id){
        try{
            Cliente cliente = clienteService.findById(id);
            return ResponseEntity.ok(cliente);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        try{
            Cliente cli = clienteService.findById(id);
            cli.setId(id);
            cli.setRun(cliente.getRun());
            cli.setNombre(cliente.getNombre());
            cli.setApellido(cliente.getApellido());
            cli.setCorreoElectronico(cliente.getCorreoElectronico());
            cli.setDireccion(cliente.getDireccion());

            clienteService.save(cli);
            return ResponseEntity.ok(cliente);
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            clienteService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }



}
