package domain.DTO;

import domain.model.Status;

import java.time.LocalDateTime;

public record SupplierResponse(
        String firstName,
        String lastName,
        String cedula,
        String phone,
        String addres,
        LocalDateTime dataRegister,
        String description,
        Status status
) {
}
