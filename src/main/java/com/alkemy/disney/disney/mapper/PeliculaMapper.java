package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.dto.PeliculaBasicDTO;
import com.alkemy.disney.disney.dto.PeliculaDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.Genero;
import com.alkemy.disney.disney.entity.Pelicula;
import com.alkemy.disney.disney.entity.Personaje;
import com.alkemy.disney.disney.repository.GeneroRepository;
import com.alkemy.disney.disney.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {

    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private GeneroMapper generoMapper;


    public Pelicula peliculaDTO2Pelicula(PeliculaDTO dto){
        Pelicula pelicula = new Pelicula();
        pelicula.setImagen(dto.getImagen());
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setFechaCreacion(dto.getFechaCreacion());
        pelicula.setCalificacion(dto.getCalificacion());

        List<Genero> generoList = generoMapper.generoDTOList2Genero(dto.getGeneros());
        pelicula.setGeneros(generoList);

        List<Personaje> personajeList = personajeMapper.personajeDTOList2Personaje(dto.getPersonajes());
        pelicula.setPersonajes(personajeList);

        return pelicula;
    }

    public PeliculaDTO pelicula2DTO(Pelicula pelicula, boolean load){
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(pelicula.getId());
        dto.setImagen(pelicula.getImagen());
        dto.setTitulo(pelicula.getTitulo());
        dto.setFechaCreacion(pelicula.getFechaCreacion());
        dto.setCalificacion(pelicula.getCalificacion());

        List<GeneroDTO> generoDTO = generoMapper.generoList2DTOList(pelicula.getGeneros());
        dto.setGeneros(generoDTO);

        if (load){
            List<PersonajeDTO> personajeDTO = personajeMapper.personajeList2DTOList(pelicula.getPersonajes(),false);
            dto.setPersonajes(personajeDTO);
        }
        return dto;
    }

    public List<PeliculaDTO> peliculaList2DTOList(List<Pelicula> peliculaList,boolean load){
        List<PeliculaDTO> dtos = new ArrayList<>();
        for (Pelicula pelicula : peliculaList ) {
            dtos.add(pelicula2DTO(pelicula,load));
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
    }

}
