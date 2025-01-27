package com.growBy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.growBy.entity.GbPrestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<GbPrestamo, Long> {
    @Query("SELECT COUNT(p) FROM GbPrestamo p WHERE p.libro.idLibro = :idLibro AND p.idEstado = 1")
    long contarPrestamosActivosPorLibro(@Param("idLibro") Long idLibro);
}