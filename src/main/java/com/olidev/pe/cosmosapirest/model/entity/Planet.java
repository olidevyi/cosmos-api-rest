package com.olidev.pe.cosmosapirest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Entity
@Table(name="planets") // Nombre de la tabla
public class Planet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="name")
    String name;
    @Column(name="radius")
    Double radius;
    @Column(name="mass")
    Double mass;
    @Column(name="orbit_period")
    Double orbit_period;
    @Column(name="distance_from_sun")
    Double distance_from_sun;
    @Column(name="registration_date")
    Date registration_date;
}
