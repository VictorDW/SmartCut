package domain.DAO;

import domain.model.Supplier;

public abstract class ISupplierDAO extends IJPAPersistence<Supplier, Long> {
    protected ISupplierDAO() {
        super(Supplier.class);
    }


}
