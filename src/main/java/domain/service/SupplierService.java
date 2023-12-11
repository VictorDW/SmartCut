package domain.service;

import domain.DAO.SupplierDAOImpl;
import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;
import domain.mapper.MapperSupplier;

public class SupplierService {

    private final SupplierDAOImpl supplierDAOImpl;
    public SupplierService(SupplierDAOImpl supplierDAOImpl) {
        this.supplierDAOImpl = supplierDAOImpl;
    }


    public SupplierResponse create(SupplierRequest supplierRequest) {

        return MapperSupplier.mapperSuppliertToSupplierResponse(
                supplierDAOImpl.save(
                        MapperSupplier.mapperSupplierRequestToSupplier(supplierRequest)
                )
        );
    }
}
