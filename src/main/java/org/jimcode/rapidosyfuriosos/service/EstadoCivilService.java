package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.EstadoCivilEntity;

import java.util.List;

public interface EstadoCivilService {

    // Mostrar estados civil
    List<EstadoCivilEntity> findAll();

    // Mostrar estados civil habilitado
    List<EstadoCivilEntity> findAllCustom();

    // Buscar estado civil por código
    EstadoCivilEntity findById(Long id);

    // Registrar estado civil
    EstadoCivilEntity add(EstadoCivilEntity estadoCivilEntity);

    // Actualizar estado civil
    EstadoCivilEntity update(EstadoCivilEntity estadoCivilEntity, Long id);

    // Eliminar de manera lógica un estado civil
    EstadoCivilEntity delete(Long id);

    // Habilitar un estado civil
    EstadoCivilEntity enable(Long id);
}
