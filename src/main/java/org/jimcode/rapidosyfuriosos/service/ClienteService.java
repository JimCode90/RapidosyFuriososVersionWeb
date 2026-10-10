package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.ClienteEntity;
import org.jimcode.rapidosyfuriosos.entity.DistritoEntity;

import java.util.List;

public interface ClienteService {

    // Mostrar los clientes
    List<ClienteEntity> findAll();

    // Mostrar clientes habilitados
    List<ClienteEntity> findAllCustom();

    // Buscar cliente por código
    ClienteEntity findById(Long id);

    // Registrar cliente
    ClienteEntity add(ClienteEntity clienteEntity);

    // Actualizar cliente
    ClienteEntity update(ClienteEntity clienteEntity, Long id);

    // Eliminar de manera lógica un cliente
    ClienteEntity delete(Long id);

    // Habilitar un cliente
    ClienteEntity enable (Long id);
}
