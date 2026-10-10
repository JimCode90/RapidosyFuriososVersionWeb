package org.jimcode.rapidosyfuriosos.repository;

import org.jimcode.rapidosyfuriosos.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolRepository extends JpaRepository<RolEntity, Long> {

    @Query("select r from RolEntity r where r.estado=true")
    List<RolEntity> findAllCustom();
}
