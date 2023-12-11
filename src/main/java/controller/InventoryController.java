package controller;

import domain.DAO.ISupplierDAO;
import domain.DAO.SupplierDAOImpl;
import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;
import infra.JPAUtils;
import domain.service.SupplierService;

public class InventoryController {

    private final SupplierService supplierService;

    public InventoryController() {

        ISupplierDAO iSupplierDAO = new SupplierDAOImpl(JPAUtils.getEntityManager());
        this.supplierService = new SupplierService(iSupplierDAO);
    }

    public SupplierResponse create(SupplierRequest supplierRequest) {
        return supplierService.create(supplierRequest);
    }


}
