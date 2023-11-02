package com.olidev.pe.cosmosapirest.model.dto;

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
    public String name;
    public Double radius;
    public Double mass;
    public Double orbit_period;
    public Double distance_from_sun;
    public Date registration_date = new Date();
}
