package domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor @NoArgsConstructor
@Embeddable
public class Person {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String addres;

    @Column(name = "data_register", nullable = false)
    private LocalDateTime dataRegister;
}
