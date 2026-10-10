package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.EmpleadoEntity;

import java.util.List;

public interface EmpleadoService {

    // Mostrar los empleados
    List<EmpleadoEntity> findAll();

    // Mostrar empleados habilitados
    List<EmpleadoEntity> findAllCustom();

    // Buscar empleado por código
    EmpleadoEntity findById(Long id);

    // Registrar empleado
    EmpleadoEntity add(EmpleadoEntity empleadoEntity);

    // Actualizar empleado
    EmpleadoEntity update(EmpleadoEntity empleadoEntity, Long id);

    // Eliminar de manera lógica un empleado
    EmpleadoEntity delete(Long id);

    // Habilitar un empleado
    EmpleadoEntity enable(Long id);
}
