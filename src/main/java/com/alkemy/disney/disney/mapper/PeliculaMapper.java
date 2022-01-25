package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.PeliculaBasicDTO;
import com.alkemy.disney.disney.dto.PeliculaDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.Pelicula;
import com.alkemy.disney.disney.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {

    @Autowired
    private PersonajeMapper personajeMapper;


    public Pelicula peliculaDTO2Pelicula(PeliculaDTO dto){
        Pelicula pelicula = new Pelicula();
        pelicula.setImagen(dto.getImagen());
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setFechaCreacion(dto.getFechaCreacion());
        pelicula.setCalificacion(dto.getCalificacion());
        pelicula.setGeneroId(dto.getGeneroId());
        return pelicula;

        /*personajes
        List<Personaje> personajeList = personajeMapper.personajeDTOList2Personaje(dto.getPersonajes());
        pelicula.setPersonajes(personajeList);*/
    }

    public PeliculaDTO pelicula2DTO(Pelicula pelicula){
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(pelicula.getId());
        dto.setImagen(pelicula.getImagen());
        dto.setTitulo(pelicula.getTitulo());
        dto.setFechaCreacion(pelicula.getFechaCreacion());
        dto.setCalificacion(pelicula.getCalificacion());
        dto.setGeneroId(pelicula.getGeneroId());
        return dto;
    }

    public List<PeliculaDTO> peliculaList2DTOList(List<Pelicula> peliculaList){
        List<PeliculaDTO> dtos = new ArrayList<>();
        for (Pelicula pelicula : peliculaList ) {
            dtos.add(pelicula2DTO(pelicula));
        }
        return dtos;
    }

    public List<PeliculaBasicDTO> peliculaList2BasicDTOList(List<Pelicula> peliculaList){
        List<PeliculaBasicDTO> dtos = new ArrayList<>();
        PeliculaBasicDTO basicDTO;
        for (Pelicula pelicula : peliculaList ) {
            basicDTO = new PeliculaBasicDTO();
            basicDTO.setId(pelicula.getId());
            basicDTO.setImagen(pelicula.getImagen());
            basicDTO.setTitulo(pelicula.getTitulo());
            basicDTO.setFechaCreacion(pelicula.getFechaCreacion());
            dtos.add(basicDTO);
        }
        return dtos;
    }

    public void peliculaRefreshValues(Pelicula pelicula, PeliculaDTO dto){
        pelicula.setImagen(dto.getImagen());
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setFechaCreacion(dto.getFechaCreacion());
        pelicula.setCalificacion(dto.getCalificacion());
        pelicula.setGeneroId(dto.getGeneroId());
    }
}
