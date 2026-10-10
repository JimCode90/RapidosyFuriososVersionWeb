package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.SexoEntity;

import java.util.List;

public interface SexoService {

    // Mostrar sexos
    List<SexoEntity> findAll();

    // Mostrar sexos habilitado
    List<SexoEntity> findAllCustom();

    // Buscar sexo por código
    SexoEntity findById(Long id);

    // Registrar sexo
    SexoEntity add(SexoEntity sexoEntity);

    // Actualizar sexo
    SexoEntity update(SexoEntity sexoEntity, Long id);

    // Eliminar de manera lógica un sexo
    SexoEntity delete(Long id);

    // Habilitar un sexo
    SexoEntity enable(Long id);
}
