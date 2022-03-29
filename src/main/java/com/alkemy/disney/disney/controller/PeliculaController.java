package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.PeliculaBasicDTO;
import com.alkemy.disney.disney.dto.PeliculaDTO;
import com.alkemy.disney.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO peliculaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaService.save(peliculaDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PeliculaDTO>> getAll(){
        return ResponseEntity.ok().body(peliculaService.getAllPeliculas());
    }

    @GetMapping("/movies")
    public ResponseEntity<List<PeliculaBasicDTO>> getBasicPeliculas(){
        return ResponseEntity.ok().body(peliculaService.getBasicPeliculas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePelicula(@PathVariable Long id){
        peliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update(@PathVariable Long id,@RequestBody PeliculaDTO peliculaDTO){
        return ResponseEntity.ok().body(peliculaService.update(id,peliculaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(peliculaService.findById(id));
    }

    @GetMapping("/filters")
    public ResponseEntity<List<PeliculaDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Set<Long> genre,
            @RequestParam(required = false,defaultValue = "ASC") String order
    ){
        List<PeliculaDTO> peliculas = peliculaService.getByFilters(name,genre,order);
        return ResponseEntity.ok(peliculas);
    }

}
