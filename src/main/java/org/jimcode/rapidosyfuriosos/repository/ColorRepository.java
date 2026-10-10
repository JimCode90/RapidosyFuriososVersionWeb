package org.jimcode.rapidosyfuriosos.repository;

import org.jimcode.rapidosyfuriosos.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {

    @Query("select c from ColorEntity c where c.estado=true")
    List<ColorEntity> findAllCustom();
}
