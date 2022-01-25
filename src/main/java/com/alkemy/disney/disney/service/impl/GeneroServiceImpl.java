package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.entity.Genero;
import com.alkemy.disney.disney.mapper.GeneroMapper;
import com.alkemy.disney.disney.repository.GeneroRepository;
import com.alkemy.disney.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public GeneroDTO save(GeneroDTO dto) {
        Genero genero = generoMapper.generoDTO2Genero(dto);
        Genero generoSave = generoRepository.save(genero);
        GeneroDTO result = generoMapper.genero2DTO(generoSave);
        return result;
    }

    @Override
    public List<GeneroDTO> getAllGeneros() {
        List<Genero> generoList = generoRepository.findAll();
        List<GeneroDTO> result = generoMapper.generoList2DTOList(generoList);
        return result;
    }
}
