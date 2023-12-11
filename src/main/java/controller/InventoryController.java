package controller;

import domain.DAO.ISupplierDAO;
import domain.DAO.SupplierDAOImpl;
import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;
import infra.JPAUtils;
import domain.service.SupplierService;

import java.util.List;

public class InventoryController {

    private final SupplierService supplierService;

    public InventoryController() {

        ISupplierDAO iSupplierDAO = new SupplierDAOImpl(JPAUtils.getEntityManager());
        this.supplierService = new SupplierService(iSupplierDAO);
    }

    public SupplierResponse create(SupplierRequest supplierRequest) {
        return supplierService.create(supplierRequest);
    }

    public SupplierResponse getById(Long id) {
        return supplierService.getById(id);
    }

    public List<SupplierResponse> getAll() {
        return supplierService.getAll();
    }

    public SupplierResponse update(Long id, SupplierRequest supplierRequest) {
        return supplierService.update(id, supplierRequest);
    }

}
