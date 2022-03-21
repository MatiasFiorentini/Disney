package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "GENEROS")
@Setter
@Getter
@SQLDelete(sql = "UPDATE genero SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "IMAGEN")
    private String imagen;

    private boolean deleted = Boolean.FALSE;
}
