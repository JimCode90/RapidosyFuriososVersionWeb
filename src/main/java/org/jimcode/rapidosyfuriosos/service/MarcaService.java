package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.MarcaEntity;

import java.util.List;

public interface MarcaService {

    // Mostrar marcas
    List<MarcaEntity> findAll();

    // Mostrar marcas habilitado
    List<MarcaEntity> findAllCustom();

    // Buscar marcas por código
    MarcaEntity findById(Long id);

    // Registrar marcas
    MarcaEntity add(MarcaEntity marcaEntity);

    // Actualizar marcas
    MarcaEntity update(MarcaEntity marcaEntity, Long id);

    // Eliminar de manera lógica una marca
    MarcaEntity delete(Long id);

    // Habilitar una marca
    MarcaEntity enable(Long id);
}
