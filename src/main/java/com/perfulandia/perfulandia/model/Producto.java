package com.perfulandia.perfulandia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Producto")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idP;

    @Column(unique = true, length = 500, nullable = false)
    private String descripcion;

    @Column(unique = true, length = 6, nullable = false)
    private Integer precio;
}
