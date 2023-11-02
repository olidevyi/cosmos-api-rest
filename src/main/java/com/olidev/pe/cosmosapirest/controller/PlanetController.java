package com.olidev.pe.cosmosapirest.controller;

import com.olidev.pe.cosmosapirest.model.dto.PlanetDto;
import com.olidev.pe.cosmosapirest.model.entity.Planet;
import com.olidev.pe.cosmosapirest.model.payload.MessageResponse;
import com.olidev.pe.cosmosapirest.service.IPlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlanetController {
    @Autowired
    private IPlanetService planetService;

    @GetMapping("/planets")
    public ResponseEntity<MessageResponse> listPlanet() {
        List<Planet> getList = planetService.listAll();
        if(getList == null || getList.isEmpty()) {
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .message("No hay registros encontrados en la tabla planets")
                    .object(null)
                    .build(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MessageResponse
                .builder()
                .message("Registro(s) encontrados")
                .object(getList)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/planet/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            Planet planet = planetService.findById(id);
            planetService.delete(planet);
            return new ResponseEntity<>(planet, HttpStatus.NO_CONTENT);
        } catch (DataAccessException error) {
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .message("El id a eliminar no existe " + "(" + error.getMessage() + ")")
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PostMapping("/planet")
    public ResponseEntity<MessageResponse> create(@RequestBody PlanetDto planetDto) {
        try {
            Planet planet = planetService.save(planetDto);
            planetDto = PlanetDto
                    .builder()
                    .id(planet.getId())
                    .name(planet.getName())
                    .radius(planet.getRadius())
                    .mass(planet.getMass())
                    .orbit_period(planet.getOrbit_period())
                    .distance_from_sun(planet.getDistance_from_sun())
                    .registration_date(planet.getRegistration_date())
                    .build();
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .message("Planet guardado correctamente.")
                    .object(planetDto)
                    .build(), HttpStatus.CREATED);
        } catch (DataAccessException error) {
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .message(error.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("/planet/{id}")
    public ResponseEntity<MessageResponse> update(@RequestBody PlanetDto planetDto, @PathVariable Long id) {
        try {
            if(planetService.existsById(id)) { // Si el id ya existe.
                System.out.println("Actualizar planeta."); // Si se imprime esto por tanto entra a la condicion correcta.
                Planet planet = planetService.save(planetDto);
                planetDto = PlanetDto
                        .builder()
                        .id(planet.getId())
                        .name(planet.getName())
                        .radius(planet.getRadius())
                        .mass(planet.getMass())
                        .orbit_period(planet.getOrbit_period())
                        .distance_from_sun(planet.getDistance_from_sun())
                        .registration_date(planet.getRegistration_date())
                        .build();
                return new ResponseEntity<>(MessageResponse
                        .builder()
                        .message("Planeta actualizado.")
                        .object(planetDto)
                        .build(), HttpStatus.CREATED );
            } else {
                return new ResponseEntity<>(MessageResponse
                        .builder()
                        .message("El planeta con id: " + id + ", no se encuentra en la base de datos.")
                        .object(null)
                        .build(), HttpStatus.NOT_FOUND );
            }
        } catch (DataAccessException error) {
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .message(error.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED );
        }
    }

    @GetMapping("/planet/{id}")
    public ResponseEntity<MessageResponse> showById(@PathVariable Long id) {
        Planet planet = planetService.findById(id);
        if(planet == null) {
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .message("El id que busca no existe en la base de datos.")
                    .object(null)
                    .build(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(MessageResponse
                .builder()
                .message("Se encontró el id en la base de datos.")
                .object(PlanetDto
                        .builder()
                        .id(planet.getId())
                        .name(planet.getName())
                        .mass(planet.getMass())
                        .radius(planet.getRadius())
                        .orbit_period(planet.getOrbit_period())
                        .distance_from_sun(planet.getDistance_from_sun())
                        .registration_date(planet.getRegistration_date())
                        .build())
                .build(), HttpStatus.OK);
    }
}
