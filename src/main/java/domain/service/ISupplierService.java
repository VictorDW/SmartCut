package domain.service;

import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;

import java.util.List;

public interface ISupplierService {

    SupplierResponse create(SupplierRequest supplierRequest);
    SupplierResponse getById(Long id);
    List<SupplierResponse> getAll();
    SupplierResponse update(Long id, SupplierRequest supplierRequest);
    void delete(Long id);
}
