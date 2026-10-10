package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.EmpleadoEntity;
import org.jimcode.rapidosyfuriosos.repository.EmpleadoRepository;
import org.jimcode.rapidosyfuriosos.service.EmpleadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Indicamos que es un servicio
@Service
// Implementamos el servicio
public class EmpleadoServiceImpl implements EmpleadoService {

    // Inyección de dependencias hacia el repositorio
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoEntity> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public List<EmpleadoEntity> findAllCustom() {
        return empleadoRepository.findAllCustom();
    }

    @Override
    public EmpleadoEntity findById(Long id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity empleadoEntity) {
        return empleadoRepository.save(empleadoEntity);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity empleadoEntity, Long id) {
        EmpleadoEntity empleado = empleadoRepository.findById(id).get();
        BeanUtils.copyProperties(empleadoEntity, empleado);
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity delete(Long id) {
        EmpleadoEntity empleado = empleadoRepository.findById(id).get();
        empleado.setEstado(false);
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity enable(Long id) {
        EmpleadoEntity empleado = empleadoRepository.findById(id).get();
        empleado.setEstado(true);
        return empleadoRepository.save(empleado);
    }
}
