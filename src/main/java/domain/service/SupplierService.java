package domain.service;

import domain.DAO.ISupplierDAO;
import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;
import domain.mapper.MapperSupplier;

public class SupplierService {

    private final ISupplierDAO iSupplierDAO;
    public SupplierService(ISupplierDAO iSupplierDAO) {
        this.iSupplierDAO = iSupplierDAO;
    }


    public SupplierResponse create(SupplierRequest supplierRequest) {

        return MapperSupplier.mapperSuppliertToSupplierResponse(
                iSupplierDAO.save(
                        MapperSupplier.mapperSupplierRequestToSupplier(supplierRequest)
                )
        );
    }
}
