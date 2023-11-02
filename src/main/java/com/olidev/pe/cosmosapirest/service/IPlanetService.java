package com.olidev.pe.cosmosapirest.service;

import com.olidev.pe.cosmosapirest.model.dto.PlanetDto;
import com.olidev.pe.cosmosapirest.model.entity.Planet;

import java.util.List;

public interface IPlanetService {
    List<Planet> listAll(); // GET all planet
    Planet save(PlanetDto planetDto); // POST planet
    Planet findById(Long id); // GET with id planet
    void delete(Planet planet); // DELETE planet
    boolean existsById(Long id); // Valid if POST or PUT a planet
}
