package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.ServicioEntity;

import java.util.List;

public interface ServicioService {

    // Mostrar servicios
    List<ServicioEntity> findAll();

    // Mostrar servicios habilitado
    List<ServicioEntity> findAllCustom();

    // Buscar servicio por código
    ServicioEntity findById(Long id);

    // Registrar servicio
    ServicioEntity add(ServicioEntity servicioEntity);

    // Actualizar servicio
    ServicioEntity update(ServicioEntity servicioEntity, Long id);

    // Eliminar de manera lógica un servicio
    ServicioEntity delete(Long id);

    // Habilitar un servicio
    ServicioEntity enable(Long id);

}
