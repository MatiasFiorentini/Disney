package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.PersonajeBasicDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.Personaje;
import com.alkemy.disney.disney.mapper.PersonajeMapper;
import com.alkemy.disney.disney.repository.PersonajeRepository;
import com.alkemy.disney.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    @Transactional
    public PersonajeDTO save(PersonajeDTO dto) {
        Personaje personaje = personajeMapper.personajeDTO2Peronaje(dto);
        Personaje personajeSave = personajeRepository.save(personaje);
        PersonajeDTO result = personajeMapper.personaje2DTO(personajeSave);
        return result;
    }

    @Override
    @Transactional
    public List<PersonajeDTO> getAllPersonajes() {
        List<Personaje> personajeList = personajeRepository.findAll();
        List<PersonajeDTO> result = personajeMapper.personajeList2DTOList(personajeList);
        return result;
    }

    @Override
    @Transactional
    public List<PersonajeBasicDTO> getBasicPersonajes() {
        List<Personaje> personajeList = personajeRepository.findAll();
        List<PersonajeBasicDTO> result = personajeMapper.personajeList2BasicDTOList(personajeList);
        return result;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        personajeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PersonajeDTO update(Long id, PersonajeDTO personajeDTO) {
        Optional<Personaje> respuesta = personajeRepository.findById(id);
        personajeMapper.personajeRefreshValues(respuesta.get(),personajeDTO);
        Personaje personajeSaved = personajeRepository.save(respuesta.get());
        PersonajeDTO result = personajeMapper.personaje2DTO(personajeSaved);
        return result;
    }

    @Override
    @Transactional
    public PersonajeDTO findById(Long id) {
        Optional<Personaje> respuesta = personajeRepository.findById(id);
        PersonajeDTO result = personajeMapper.personaje2DTO(respuesta.get());
        return result;
    }
}
