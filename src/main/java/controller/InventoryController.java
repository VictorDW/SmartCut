package controller;

import domain.DAO.SupplierDAOImpl;
import infra.JPAUtils;
import domain.service.SupplierService;

public class InventoryController {

    private final SupplierService supplierService;

    public InventoryController() {

        SupplierDAOImpl supplierDAOImpl = new SupplierDAOImpl(JPAUtils.getEntityManager());
        this.supplierService = new SupplierService(supplierDAOImpl);
    }

}
