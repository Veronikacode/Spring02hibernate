package pl.coderslab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nazwa jest wymagana.")
    private String name;

    @Pattern(regexp = "\\d{10}", message = "Numer NIP musi składać się z 10 cyfr.")
    private String nip;

    @Pattern(regexp = "\\d{9}", message = "Numer REGON musi składać się z 9 cyfr.")
    private String regon;

    private String city;
    private String zipCode;
    private String address;

}