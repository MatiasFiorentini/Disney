package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.entity.Genero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public Genero generoDTO2Genero(GeneroDTO dto){
        Genero genero = new Genero();
        genero.setNombre(dto.getNombre());
        genero.setImagen(dto.getImagen());
        return genero;
    }

    public GeneroDTO genero2DTO(Genero genero){
        GeneroDTO dto = new GeneroDTO();
        dto.setId(genero.getId());
        dto.setNombre(genero.getNombre());
        dto.setImagen(genero.getImagen());
        return dto;
    }

    public List<GeneroDTO> generoList2DTOList(List<Genero> generoList){
        List<GeneroDTO> dtos = new ArrayList<>();
        for (Genero genero : generoList ) { //Recorro generoList
            dtos.add(genero2DTO(genero));
        }
        return dtos;
    }

    public List<Genero> generoDTOList2Genero(List<GeneroDTO> generoDTO){
        List<Genero> generoList = new ArrayList<>();
        for (GeneroDTO dto: generoDTO) {
            generoList.add(generoDTO2Genero(dto));
        }
        return generoList;
    }


}
