package com.growBy.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.growBy.entity.GbLibro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class LibroPaginacionRepository {

	  @PersistenceContext
	    private EntityManager entityManager;

	    public List<GbLibro> listarLibroPaginados(int pagina, int tamanio) {

	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<GbLibro> criteriaQuery = criteriaBuilder.createQuery(GbLibro.class);

	        Root<GbLibro> root = criteriaQuery.from(GbLibro.class);

	        criteriaQuery.select(root);

	        return entityManager.createQuery(criteriaQuery)
	                .setFirstResult(pagina * tamanio)
	                .setMaxResults(tamanio)
	                .getResultList();
	    }

	    public long contarLibro() {
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);

	        Root<GbLibro> root = countQuery.from(GbLibro.class);

	        countQuery.select(criteriaBuilder.count(root));

	        return entityManager.createQuery(countQuery).getSingleResult();
	    }
}
