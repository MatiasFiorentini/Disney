package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.PeliculaDTO;
import com.alkemy.disney.disney.dto.PersonajeBasicDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {


    public Personaje personajeDTO2Peronaje(PersonajeDTO dto){
        Personaje personaje = new Personaje();
        personaje.setNombre(dto.getNombre());
        personaje.setImagen(dto.getImagen());
        personaje.setEdad(dto.getEdad());
        personaje.setPeso(dto.getPeso());
        personaje.setHistoria(dto.getHistoria());
        return personaje;
    }

    public PersonajeDTO personaje2DTO(Personaje personaje){
        PersonajeDTO dto = new PersonajeDTO();
        dto.setId(personaje.getId());
        dto.setNombre(personaje.getNombre());
        dto.setImagen(personaje.getImagen());
        dto.setEdad(personaje.getEdad());
        dto.setPeso(personaje.getPeso());
        dto.setHistoria(personaje.getHistoria());
        return dto;
    }

    public List<PersonajeDTO> personajeList2DTOList(List<Personaje> personajeList){
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (Personaje personaje : personajeList ) {
            dtos.add(personaje2DTO(personaje));
        }
        return dtos;
    }

    public List<PersonajeBasicDTO> personajeList2BasicDTOList(List<Personaje> personajeList){
        List<PersonajeBasicDTO> dtos = new ArrayList<>();
        PersonajeBasicDTO basicDTO;
        for (Personaje personaje : personajeList ) {
            basicDTO = new PersonajeBasicDTO();
            basicDTO.setId(personaje.getId());
            basicDTO.setNombre(personaje.getNombre());
            basicDTO.setImagen(personaje.getImagen());
            dtos.add(basicDTO);
        }
        return dtos;
    }

    public void personajeRefreshValues(Personaje personaje,PersonajeDTO dto){
        personaje.setNombre(dto.getNombre());
        personaje.setImagen(dto.getImagen());
        personaje.setEdad(dto.getEdad());
        personaje.setPeso(dto.getPeso());
        personaje.setHistoria(dto.getHistoria());
    }

    /*public List<Personaje> personajeDTOList2Personaje(List<PersonajeDTO> personajeDTO){
        List<Personaje> personajeList = new ArrayList<>();
        for (PersonajeDTO dto: personajeDTO) {
            personajeList.add(personajeDTO2Peronaje(dto));
        }
        return personajeList;
    }*/

}
