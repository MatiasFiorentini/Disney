package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.PersonajeBasicDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.Personaje;

import java.util.List;

public interface PersonajeService {

    PersonajeDTO save(PersonajeDTO dto);

    List<PersonajeDTO> getAllPersonajes();

    List<PersonajeBasicDTO> getBasicPersonajes();

    void delete(Long id);

    PersonajeDTO update(Long id, PersonajeDTO personajeDTO);

    PersonajeDTO findById(Long id);
}
