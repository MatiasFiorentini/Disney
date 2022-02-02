package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.PersonajeBasicDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.dto.PersonajeFiltersDTO;
import com.alkemy.disney.disney.entity.Personaje;
import com.alkemy.disney.disney.exception.ParamNotFound;
import com.alkemy.disney.disney.mapper.PersonajeMapper;
import com.alkemy.disney.disney.repository.PersonajeRepository;
import com.alkemy.disney.disney.repository.specifications.PersonajeSpecifications;
import com.alkemy.disney.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PersonajeSpecifications personajeSpecifications;

    @Override
    public PersonajeDTO save(PersonajeDTO dto) {
        Personaje personaje = personajeMapper.personajeDTO2Peronaje(dto);
        Personaje personajeSave = personajeRepository.save(personaje);
        PersonajeDTO result = personajeMapper.personaje2DTO(personajeSave);
        return result;
    }

    @Override
    public List<PersonajeDTO> getAllPersonajes() {
        List<Personaje> personajeList = personajeRepository.findAll();
        List<PersonajeDTO> result = personajeMapper.personajeList2DTOList(personajeList);
        return result;
    }

    @Override
    public List<PersonajeBasicDTO> getBasicPersonajes() {
        List<Personaje> personajeList = personajeRepository.findAll();
        List<PersonajeBasicDTO> result = personajeMapper.personajeList2BasicDTOList(personajeList);
        return result;
    }

    @Override
    public boolean delete(Long id) {
        if (personajeRepository.existsById(id)){
            personajeRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public PersonajeDTO update(Long id, PersonajeDTO personajeDTO) {
        Optional<Personaje> respuesta = personajeRepository.findById(id);
        if (!respuesta.isPresent()){
            throw new ParamNotFound("Id de personaje no válido");
        }
        personajeMapper.personajeRefreshValues(respuesta.get(),personajeDTO);
        Personaje personajeSaved = personajeRepository.save(respuesta.get());
        PersonajeDTO result = personajeMapper.personaje2DTO(personajeSaved);
        return result;
    }

    @Override
    public PersonajeDTO findById(Long id) {
        Optional<Personaje> respuesta = personajeRepository.findById(id);
        if (!respuesta.isPresent()){
            throw new ParamNotFound("Id de personaje no válido");
        }
        PersonajeDTO result = personajeMapper.personaje2DTO(respuesta.get());
        return result;
    }

    @Override
    public List<PersonajeDTO> getByFilters(String name, Integer age, Set<Long> movies, String order) {
        PersonajeFiltersDTO filtersDTO = new PersonajeFiltersDTO(name,age,movies,order);
        List<Personaje> personajeList = personajeRepository.findAll(personajeSpecifications.getByFilters(filtersDTO));
        List<PersonajeDTO> personajeDTOS = personajeMapper.personajeList2DTOList(personajeList);
        return personajeDTOS;
    }
}
