package com.olidev.pe.cosmosapirest.model.dao;

import com.olidev.pe.cosmosapirest.model.entity.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetDao extends CrudRepository<Planet, Long> {
}
