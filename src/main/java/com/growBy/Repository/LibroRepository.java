package com.growBy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growBy.entity.GbLibro;

@Repository
public interface LibroRepository extends JpaRepository<GbLibro, Long> {
	
}
