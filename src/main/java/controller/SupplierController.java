package controller;

import domain.DAO.ISupplierDAO;
import domain.DAO.impl.SupplierDAOImpl;
import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;
import domain.service.ISupplierService;
import infra.JPAUtils;
import domain.service.SupplierServiceImpl;

import java.util.List;

public class SupplierController {

    private final ISupplierService supplierService;

    public SupplierController() {

        ISupplierDAO iSupplierDAO = new SupplierDAOImpl();
        this.supplierService = new SupplierServiceImpl(iSupplierDAO);
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
    public void delete(Long id) {
        supplierService.delete(id);
    }

}
