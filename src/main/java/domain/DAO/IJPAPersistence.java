package domain.DAO;

import infra.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;


public abstract class IJPAPersistence<T, ID> {

     protected EntityManager entityManager;
     private final Class<T> entityClass;

     protected IJPAPersistence(Class<T> entityClass) {
          this.entityManager = JPAUtils.getEntityManager();
          this.entityClass = entityClass;
     }

     public T save(T t) {
          entityManager.getTransaction().begin();
          T supplierTemp = entityManager.merge(t);
          entityManager.getTransaction().commit();
          return supplierTemp;
     }

     public Optional<T> getById(ID id) {
          try {
               return Optional.of(
                       entityManager.find(entityClass, id));
          }catch (NoResultException e) {
               return Optional.empty();
          }
     }

     public List<T> getAll() {

          CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
          CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
          Root<T> rootEntry = criteriaQuery.from(entityClass);
          CriteriaQuery<T> all = criteriaQuery.select(rootEntry);

          return entityManager.createQuery(all).getResultList();
     }

     public void delete(ID id) {
          getById(id).ifPresent(
                  t -> this.entityManager.remove(t)
          );
     }
}
