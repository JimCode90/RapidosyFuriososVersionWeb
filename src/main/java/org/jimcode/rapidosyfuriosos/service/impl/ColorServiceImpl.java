package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.ColorEntity;
import org.jimcode.rapidosyfuriosos.repository.ColorRepository;
import org.jimcode.rapidosyfuriosos.service.ColorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<ColorEntity> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public List<ColorEntity> findAllCustom() {
        return colorRepository.findAllCustom();
    }

    @Override
    public ColorEntity findById(Long id) {
        return colorRepository.findById(id).get();
    }

    @Override
    public ColorEntity add(ColorEntity colorEntity) {
        return colorRepository.save(colorEntity);
    }

    @Override
    public ColorEntity update(ColorEntity colorEntity, Long id) {
        ColorEntity color = colorRepository.findById(id).get();
        BeanUtils.copyProperties(colorEntity, color);
        return colorRepository.save(color);
    }

    @Override
    public ColorEntity delete(Long id) {
        ColorEntity color = colorRepository.findById(id).get();
        color.setEstado(false);
        return colorRepository.save(color);
    }

    @Override
    public ColorEntity enable(Long id) {
        ColorEntity color = colorRepository.findById(id).get();
        color.setEstado(true);
        return colorRepository.save(color);
    }
}
