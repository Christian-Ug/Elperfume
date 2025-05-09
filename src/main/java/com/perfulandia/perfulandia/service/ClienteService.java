package com.perfulandia.perfulandia.service;

import com.perfulandia.perfulandia.model.Cliente;
import com.perfulandia.perfulandia.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional


public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }
    public Cliente findById(Long id){
        return clienteRepository.findById(id).get();
    }
    public Cliente save (Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public void delete (Long id){
        clienteRepository.deleteById(id);
    }

}
