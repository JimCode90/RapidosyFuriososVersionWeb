package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.ClienteEntity;
import org.jimcode.rapidosyfuriosos.repository.ClienteRepository;
import org.jimcode.rapidosyfuriosos.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Indicamos que es un servicio
@Service
// Implementamos el servicio
public class ClienteServiceImpl implements ClienteService {

    // Inyección de dependencias hacia el repositorio
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<ClienteEntity> findAllCustom() {
        return clienteRepository.findAllCustom();
    }

    @Override
    public ClienteEntity findById(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public ClienteEntity add(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }

    @Override
    public ClienteEntity update(ClienteEntity clienteEntity, Long id) {
        ClienteEntity cliente = clienteRepository.findById(id).get();
        BeanUtils.copyProperties(clienteEntity, cliente);
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteEntity delete(Long id) {
        ClienteEntity cliente = clienteRepository.findById(id).get();
        cliente.setEstado(false);
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteEntity enable(Long id) {
        ClienteEntity cliente = clienteRepository.findById(id).get();
        cliente.setEstado(true);
        return clienteRepository.save(cliente);
    }
}
