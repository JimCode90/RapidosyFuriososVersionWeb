package org.jimcode.rapidosyfuriosos.repository;

import org.jimcode.rapidosyfuriosos.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {

    @Query("select m from MarcaEntity m where m.estado=true")
    List<MarcaEntity> findAllCustom();
}
