package com.growBy.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.growBy.entity.GbPrestamo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class PrestamoPaginacionRepository  {
	
	  @PersistenceContext
	    private EntityManager entityManager;

	    public List<GbPrestamo> listarPrestamosPaginados(int pagina, int tamanio) {
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<GbPrestamo> criteriaQuery = criteriaBuilder.createQuery(GbPrestamo.class);

	        Root<GbPrestamo> root = criteriaQuery.from(GbPrestamo.class);

	        criteriaQuery.select(root);

	        return entityManager.createQuery(criteriaQuery)
	                .setFirstResult(pagina * tamanio)
	                .setMaxResults(tamanio)
	                .getResultList();
	    }

	    public long contarPrestamos() {
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);

	        Root<GbPrestamo> root = countQuery.from(GbPrestamo.class);

	        countQuery.select(criteriaBuilder.count(root));

	        return entityManager.createQuery(countQuery).getSingleResult();
	    }
	    

	    @SuppressWarnings("unchecked")
		public List<GbPrestamo> listarPrestamosPorLibroPaginados(Long idLibro, int pagina, int tamanio) {
	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<GbPrestamo> cq = cb.createQuery(GbPrestamo.class);
	        Root<GbPrestamo> prestamoRoot = cq.from(GbPrestamo.class);

	        Predicate libroPredicate = cb.equal(prestamoRoot.get("libro").get("idLibro"), idLibro);
	        cq.where(libroPredicate);

	        Query query = entityManager.createQuery(cq);

	        query.setFirstResult((pagina - 1) * tamanio);
	        query.setMaxResults(tamanio);

	        return query.getResultList();
	    }

	    public long contarPrestamosPorLibro(Long idLibro) {
	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
	        Root<GbPrestamo> prestamoRoot = cq.from(GbPrestamo.class);

	        Predicate libroPredicate = cb.equal(prestamoRoot.get("libro").get("idLibro"), idLibro);
	        cq.where(libroPredicate);

	        cq.select(cb.count(prestamoRoot));

	        return entityManager.createQuery(cq).getSingleResult();
	    }

}
