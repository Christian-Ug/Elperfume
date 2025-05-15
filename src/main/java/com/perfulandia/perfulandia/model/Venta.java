package com.perfulandia.perfulandia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Venta")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idV;

    @Column(unique = true, length = 16, nullable = false)
    private String numTarjeta;

    @Column(unique = true, length = 4, nullable = false)
    private String fechaCaducidad;

    @Column(unique = true, length = 3, nullable = false)
    private String cvv;


}
