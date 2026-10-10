package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.VehiculoEntity;
import org.jimcode.rapidosyfuriosos.repository.VehiculoRepository;
import org.jimcode.rapidosyfuriosos.service.VehiculoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Indicamos que es un servicio
@Service
// Implementamos el servicio
public class VehiculoServiceImpl implements VehiculoService {

    // Inyección de dependencias hacia el repositorio
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoEntity> findAll() {
        return vehiculoRepository.findAll();
    }

    @Override
    public List<VehiculoEntity> findAllCustom() {
        return vehiculoRepository.findAllCustom();
    }

    @Override
    public VehiculoEntity findById(Long id) {
        return vehiculoRepository.findById(id).get();
    }

    @Override
    public VehiculoEntity add(VehiculoEntity vehiculoEntity) {
        return vehiculoRepository.save(vehiculoEntity);
    }

    @Override
    public VehiculoEntity update(VehiculoEntity vehiculoEntity, Long id) {
        VehiculoEntity vehiculo = vehiculoRepository.findById(id).get();
        BeanUtils.copyProperties(vehiculoEntity, vehiculo);
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public VehiculoEntity delete(Long id) {
        VehiculoEntity vehiculo = vehiculoRepository.findById(id).get();
        vehiculo.setEstado(false);
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public VehiculoEntity enable(Long id) {
        VehiculoEntity vehiculo = vehiculoRepository.findById(id).get();
        vehiculo.setEstado(true);
        return vehiculoRepository.save(vehiculo);
    }
}
