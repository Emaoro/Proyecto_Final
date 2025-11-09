package com.cog.sistemas_atleta.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "atletas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Double salarioBase;
}
