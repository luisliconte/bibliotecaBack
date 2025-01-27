package com.growBy.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.growBy.entity.GbAutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class AutorPaginacionRepository {

	  @PersistenceContext
	    private EntityManager entityManager;

	    public List<GbAutor> listarAutorPaginados(int pagina, int tamanio) {
	        // Crear el CriteriaBuilder y CriteriaQuery
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<GbAutor> criteriaQuery = criteriaBuilder.createQuery(GbAutor.class);

	        // Definir la raíz de la consulta (tabla principal)
	        Root<GbAutor> root = criteriaQuery.from(GbAutor.class);

	        // Especificar los campos que se desean seleccionar (puedes incluir joins aquí si es necesario)
	        criteriaQuery.select(root);

	        // Crear la consulta con paginación
	        return entityManager.createQuery(criteriaQuery)
	                .setFirstResult(pagina * tamanio) // Índice inicial (offset)
	                .setMaxResults(tamanio)          // Tamaño de página (limit)
	                .getResultList();
	    }

	    public long contarAutor() {
	        // Crear el CriteriaBuilder y CriteriaQuery
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);

	        // Definir la raíz de la consulta
	        Root<GbAutor> root = countQuery.from(GbAutor.class);

	        // Especificar el conteo total
	        countQuery.select(criteriaBuilder.count(root));

	        return entityManager.createQuery(countQuery).getSingleResult();
	    }
}
