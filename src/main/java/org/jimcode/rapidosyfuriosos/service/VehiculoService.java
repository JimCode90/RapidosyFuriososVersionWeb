package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.VehiculoEntity;

import java.util.List;

public interface VehiculoService {

    // Mostrar los vehículos
    List<VehiculoEntity> findAll();

    // Mostrar vehículos habilitados
    List<VehiculoEntity> findAllCustom();

    // Buscar vehículo por código
    VehiculoEntity findById(Long id);

    // Registrar vehículo
    VehiculoEntity add(VehiculoEntity vehiculoEntity);

    // Actualizar vehículo
    VehiculoEntity update(VehiculoEntity vehiculoEntity, Long id);

    // Eliminar de manera lógica un vehículo
    VehiculoEntity delete(Long id);

    // Habilitar un vehículo
    VehiculoEntity enable(Long id);
}
