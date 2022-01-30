package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaFiltersDTO {

    private String name;
    private String genre;
    private String order;

    public PeliculaFiltersDTO(String name, String genre, String order) {
        this.name = name;
        this.genre = genre;
        this.order = order;
    }

    public boolean isASC(){
        return order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDES(){
        return order.compareToIgnoreCase("DES") == 0;
    }
}
