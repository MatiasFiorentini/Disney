package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonajeFiltersDTO {

    private String name;
    private Integer age;
    private Set<Long> movies;
    private String order;

    public PersonajeFiltersDTO(String name, Integer age, Set<Long> movies, String order) {
        this.name = name;
        this.age = age;
        this.movies = movies;
        this.order = order;
    }

    public boolean isASC(){
        return order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDES(){
        return order.compareToIgnoreCase("DES") == 0;
    }
}
