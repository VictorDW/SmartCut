package domain.DAO.impl;

import domain.DAO.ISupplierDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import domain.model.Status;
import domain.model.Supplier;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class SupplierDAOImpl implements ISupplierDAO {

    private final EntityManager entityManager;

    @Override
    public Supplier save(Supplier supplier) {
        entityManager.getTransaction().begin();
        Supplier supplierTemp = entityManager.merge(supplier);
        entityManager.getTransaction().commit();
        return supplierTemp;
    }

    @Override
    public Optional<Supplier> getById(Long id) {
        try {
            String query = "SELECT S  FROM Supplier S WHERE NOT (S.status=:status) AND S.id=:id";

            return Optional.of(
                        entityManager.createQuery(query, Supplier.class)
                                            .setParameter("status", Status.INACTIVE)
                                            .setParameter("id",id)
                                            .getSingleResult()
            );
        }catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Supplier> getAll() {
        String query = "SELECT S  FROM Supplier S WHERE NOT (S.status=:status)";

       return entityManager.createQuery(query, Supplier.class)
                            .setParameter("status", Status.INACTIVE)
                            .getResultList();
    }
}
