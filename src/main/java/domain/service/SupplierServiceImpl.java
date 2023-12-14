package domain.service;

import domain.DAO.ISupplierDAO;
import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;
import domain.mapper.MapperSupplier;

import java.util.List;

public class SupplierServiceImpl implements ISupplierService {

    private final ISupplierDAO supplierDAO;
    public SupplierServiceImpl(ISupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
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

    public SupplierResponse update(Long id, SupplierRequest supplierRequest) {

       return supplierDAO.getById(id)
                .map(supplier ->
                            MapperSupplier.mapperSuppliertToSupplierResponse(
                                supplierDAO.save(
                                        MapperSupplier.mapperSupplierUpdate(supplier, supplierRequest)
                                )
                            )
                )
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        supplierDAO.getById(id).ifPresent(
                supplier ->
                    supplierDAO.save(
                            MapperSupplier.mapperSupplierDelete(supplier)
                    )
        );
    }


}
