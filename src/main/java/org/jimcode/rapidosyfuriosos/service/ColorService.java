package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.ColorEntity;

import java.util.List;

public interface ColorService {

    // Mostrar colores
    List<ColorEntity> findAll();

    // Mostrar colores habilitado
    List<ColorEntity> findAllCustom();

    // Buscar color por código
    ColorEntity findById(Long id);

    // Registrar color
    ColorEntity add(ColorEntity colorEntity);

    // Actualizar color
    ColorEntity update(ColorEntity colorEntity, Long id);

    // Eliminar de manera lógica un color
    ColorEntity delete(Long id);

    // Habilitar un color
    ColorEntity enable(Long id);
}
