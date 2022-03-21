package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Long> {

    @Query(value = "SELECT g FROM Genero g WHERE g.nombre LIKE %:nombre%")
    public List<Genero> search(@Param("nombre")String nombre);
}
