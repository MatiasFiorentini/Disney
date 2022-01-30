package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.PersonajeBasicDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.Personaje;

import java.util.List;
import java.util.Set;

public interface PersonajeService {

    PersonajeDTO save(PersonajeDTO dto);

    List<PersonajeDTO> getAllPersonajes();

    List<PersonajeBasicDTO> getBasicPersonajes();

    boolean delete(Long id);

    PersonajeDTO update(Long id, PersonajeDTO personajeDTO);

    PersonajeDTO findById(Long id);

    List<PersonajeDTO> getByFilters(String name, Integer age, Set<Long> movies, String order);
}
