package org.jimcode.rapidosyfuriosos.repository;

import org.jimcode.rapidosyfuriosos.entity.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicioRepository extends JpaRepository<ServicioEntity, Long> {

    @Query("select s from ServicioEntity s where s.estado=true")
    List<ServicioEntity> findAllCustom();
}
