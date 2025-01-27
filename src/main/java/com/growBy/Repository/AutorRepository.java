package com.growBy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growBy.entity.GbAutor;

@Repository
public interface AutorRepository extends JpaRepository<GbAutor, Long> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}