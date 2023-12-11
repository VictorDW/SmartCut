package domain.DTO;

public record SupplierRequest(
        String firstName,
        String lastName,
        String cedula,
        String phone,
        String addres,
        String description
) {
}
