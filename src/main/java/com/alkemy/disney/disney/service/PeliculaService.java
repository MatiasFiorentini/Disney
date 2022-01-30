package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.PeliculaBasicDTO;
import com.alkemy.disney.disney.dto.PeliculaDTO;

import java.util.List;

public interface PeliculaService {

    PeliculaDTO save(PeliculaDTO dto);

    List<PeliculaDTO> getAllPeliculas();

    List<PeliculaBasicDTO> getBasicPeliculas();

    boolean delete(Long id);

    PeliculaDTO update(Long id, PeliculaDTO peliculaDTO);

    PeliculaDTO findById(Long id);

    List<PeliculaDTO> getByFilters(String name,String genre,String order);
}

