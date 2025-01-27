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
	        // Crear el CriteriaBuilder y CriteriaQuery
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<GbPrestamo> criteriaQuery = criteriaBuilder.createQuery(GbPrestamo.class);

	        // Definir la raíz de la consulta (tabla principal)
	        Root<GbPrestamo> root = criteriaQuery.from(GbPrestamo.class);

	        // Especificar los campos que se desean seleccionar (puedes incluir joins aquí si es necesario)
	        criteriaQuery.select(root);

	        // Crear la consulta con paginación
	        return entityManager.createQuery(criteriaQuery)
	                .setFirstResult(pagina * tamanio) // Índice inicial (offset)
	                .setMaxResults(tamanio)          // Tamaño de página (limit)
	                .getResultList();
	    }

	    public long contarPrestamos() {
	        // Crear el CriteriaBuilder y CriteriaQuery
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);

	        // Definir la raíz de la consulta
	        Root<GbPrestamo> root = countQuery.from(GbPrestamo.class);

	        // Especificar el conteo total
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

	        query.setFirstResult((pagina - 1) * tamanio); // Página actual
	        query.setMaxResults(tamanio); // Tamaño de la página

	        return query.getResultList();
	    }

	    public long contarPrestamosPorLibro(Long idLibro) {
	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
	        Root<GbPrestamo> prestamoRoot = cq.from(GbPrestamo.class);

	        // Filtrar por idLibro
	        Predicate libroPredicate = cb.equal(prestamoRoot.get("libro").get("idLibro"), idLibro);
	        cq.where(libroPredicate);

	        // Realizar el conteo
	        cq.select(cb.count(prestamoRoot));

	        return entityManager.createQuery(cq).getSingleResult();
	    }

}
