package domain.mapper;

import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;
import domain.model.Status;
import domain.model.Supplier;

import java.time.LocalDateTime;

public class MapperSupplier {

    private MapperSupplier() {}

    public static Supplier mapperSupplierRequestToSupplier(SupplierRequest supplierRequest) {

         Supplier supplier = new Supplier();

         supplier.getPerson().setFirstName(supplierRequest.firstName());
         supplier.getPerson().setLastName(supplierRequest.lastName());
         supplier.getPerson().setCedula(supplierRequest.cedula());
         supplier.getPerson().setAddres(supplierRequest.addres());
         supplier.getPerson().setPhone(supplierRequest.phone());
         supplier.getPerson().setDataRegister(LocalDateTime.now());
         supplier.setDescription(supplierRequest.description());
         supplier.setStatus(Status.ACTIVE);

        return supplier;
    }

    public static SupplierResponse mapperSuppliertToSupplierResponse(Supplier supplier) {

        return new SupplierResponse(
                supplier.getPerson().getFirstName(),
                supplier.getPerson().getLastName(),
                supplier.getPerson().getCedula(),
                supplier.getPerson().getPhone(),
                supplier.getPerson().getAddres(),
                supplier.getPerson().getDataRegister(),
                supplier.getDescription(),
                supplier.getStatus()
        );
    }
}
