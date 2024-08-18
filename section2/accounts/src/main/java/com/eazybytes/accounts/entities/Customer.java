package com.eazybytes.accounts.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

        private String name;

        private String email;

        @Column(name = "mobile_number")
        private String mobileNumber;
}
