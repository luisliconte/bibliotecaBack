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
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<GbAutor> criteriaQuery = criteriaBuilder.createQuery(GbAutor.class);

	        Root<GbAutor> root = criteriaQuery.from(GbAutor.class);

	        criteriaQuery.select(root);

	        return entityManager.createQuery(criteriaQuery)
	                .setFirstResult(pagina * tamanio)
	                .setMaxResults(tamanio)
	                .getResultList();
	    }

	    public long contarAutor() {
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);

	        Root<GbAutor> root = countQuery.from(GbAutor.class);

	        countQuery.select(criteriaBuilder.count(root));

	        return entityManager.createQuery(countQuery).getSingleResult();
	    }
}
