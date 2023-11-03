package com.olidev.pe.cosmosapirest.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class PlanetDto implements Serializable {
    public Long id;
    @Size(min = 2, max = 25)
    @NotEmpty(message = "Nombre requerido!")
    public String name;
    public Double radius;
    public Double mass;
    public Double orbit_period;
    public Double distance_from_sun;
    public Date registration_date = new Date();
}
