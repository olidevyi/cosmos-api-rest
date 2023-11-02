package com.olidev.pe.cosmosapirest.service.impl;

import com.olidev.pe.cosmosapirest.model.dao.PlanetDao;
import com.olidev.pe.cosmosapirest.model.dto.PlanetDto;
import com.olidev.pe.cosmosapirest.model.entity.Planet;
import com.olidev.pe.cosmosapirest.service.IPlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanetImplService implements IPlanetService {
    @Autowired
    private PlanetDao planetDao;

    @Override
    public List<Planet> listAll() {
        return (List<Planet>) planetDao.findAll();
    }

    @Transactional
    @Override
    public Planet save(PlanetDto planetDto) {
        Planet planet = Planet
                .builder()
                .id(planetDto.getId())
                .name(planetDto.getName())
                .radius(planetDto.getRadius())
                .mass(planetDto.getMass())
                .orbit_period(planetDto.getOrbit_period())
                .distance_from_sun(planetDto.getDistance_from_sun())
                .registration_date(planetDto.getRegistration_date())
                .build();
        return planetDao.save(planet);
    }

    @Transactional(readOnly = true)
    @Override
    public Planet findById(Long id) {
        return planetDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Planet planet) {
        planetDao.delete(planet);
    }

    @Override
    public boolean existsById(Long id) {
        return planetDao.existsById(id);
    }
}
