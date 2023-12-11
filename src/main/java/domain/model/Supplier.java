package domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Person person;

    private String description;

    @OneToMany(mappedBy = "supplier")
    private Set<Materials> materials;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

}
