package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.RolEntity;

import java.util.List;

public interface RolService {

    // Mostrar roles
    List<RolEntity> findAll();

    // Mostrar roles habilitado
    List<RolEntity> findAllCustom();

    // Buscar rol por código
    RolEntity findById(Long id);

    // Registrar rol
    RolEntity add(RolEntity rolEntity);

    // Actualizar rol
    RolEntity update(RolEntity rolEntity, Long id);

    // Eliminar de manera lógica un rol
    RolEntity delete(Long id);

    // Habilitar un rol
    RolEntity enable(Long id);

}
