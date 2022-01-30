package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.PeliculaBasicDTO;
import com.alkemy.disney.disney.dto.PeliculaDTO;
import com.alkemy.disney.disney.dto.PeliculaFiltersDTO;
import com.alkemy.disney.disney.entity.Pelicula;
import com.alkemy.disney.disney.mapper.PeliculaMapper;
import com.alkemy.disney.disney.repository.PeliculaRepository;
import com.alkemy.disney.disney.repository.specifications.PeliculaSpecifications;
import com.alkemy.disney.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaMapper peliculaMapper;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private PeliculaSpecifications peliculaSpecifications;

    @Override
    @Transactional
    public PeliculaDTO save(PeliculaDTO dto) {
        Pelicula pelicula = peliculaMapper.peliculaDTO2Pelicula(dto);
        Pelicula peliculaSave = peliculaRepository.save(pelicula);
        PeliculaDTO result = peliculaMapper.pelicula2DTO(peliculaSave);
        return result;
    }

    @Override
    @Transactional
    public List<PeliculaDTO> getAllPeliculas() {
        List<Pelicula> peliculaList = peliculaRepository.findAll();
        List<PeliculaDTO> result = peliculaMapper.peliculaList2DTOList(peliculaList);
        return result;
    }

    @Override
    @Transactional
    public List<PeliculaBasicDTO> getBasicPeliculas() {
        List<Pelicula> peliculaList = peliculaRepository.findAll();
        List<PeliculaBasicDTO> result = peliculaMapper.peliculaList2BasicDTOList(peliculaList);
        return result;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if (peliculaRepository.existsById(id)){
            peliculaRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public PeliculaDTO update(Long id, PeliculaDTO peliculaDTO) {
        Optional<Pelicula> respuesta = peliculaRepository.findById(id);
        peliculaMapper.peliculaRefreshValues(respuesta.get(),peliculaDTO);
        Pelicula peliculaSaved = peliculaRepository.save(respuesta.get());
        PeliculaDTO result = peliculaMapper.pelicula2DTO(peliculaSaved);
        return result;
    }

    @Override
    @Transactional
    public PeliculaDTO findById(Long id) {
        Optional<Pelicula> respuesta = peliculaRepository.findById(id);
        PeliculaDTO result = peliculaMapper.pelicula2DTO(respuesta.get());
        return result;
    }

    @Override
    public List<PeliculaDTO> getByFilters(String name, String genre, String order) {
        PeliculaFiltersDTO filtersDTO = new PeliculaFiltersDTO(name, genre, order);
        List<Pelicula> peliculaList = peliculaRepository.findAll(peliculaSpecifications.getByFilters(filtersDTO));
        List<PeliculaDTO> peliculaDTOS = peliculaMapper.peliculaList2DTOList(peliculaList);
        return peliculaDTOS;
    }
}
