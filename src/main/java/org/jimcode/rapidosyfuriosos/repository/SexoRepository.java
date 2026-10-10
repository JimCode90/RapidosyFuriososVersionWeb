package org.jimcode.rapidosyfuriosos.repository;

import org.jimcode.rapidosyfuriosos.entity.SexoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SexoRepository extends JpaRepository<SexoEntity, Long> {

    @Query("select s from SexoEntity s where s.estado=true")
    List<SexoEntity> findAllCustom();
}
