package domain.service;

import domain.DAO.ISupplierDAO;
import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;
import domain.mapper.MapperSupplier;

import java.util.List;

public class SupplierService {

    private final ISupplierDAO supplierDAO;
    public SupplierService(ISupplierDAO iSupplierDAO) {
        this.supplierDAO = iSupplierDAO;
    }


    public SupplierResponse create(SupplierRequest supplierRequest) {

        return MapperSupplier.mapperSuppliertToSupplierResponse(
                supplierDAO.save(
                        MapperSupplier.mapperSupplierRequestToSupplier(supplierRequest)
                )
        );
    }

    public SupplierResponse getById(Long id) {
        return supplierDAO.getById(id)
                .map(MapperSupplier::mapperSuppliertToSupplierResponse)
                .orElse(null);
    }

    public List<SupplierResponse> getAll() {
        return supplierDAO.getAll()
                .stream()
                .map(MapperSupplier::mapperSuppliertToSupplierResponse)
                .toList();
    }
}
