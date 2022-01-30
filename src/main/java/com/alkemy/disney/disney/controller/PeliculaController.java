package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.PeliculaBasicDTO;
import com.alkemy.disney.disney.dto.PeliculaDTO;
import com.alkemy.disney.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO peliculaDTO){
        PeliculaDTO peliculaSaved = peliculaService.save(peliculaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSaved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PeliculaDTO>> getAll(){
        List<PeliculaDTO> peliculaList = peliculaService.getAllPeliculas();
        return ResponseEntity.ok().body(peliculaList);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<PeliculaBasicDTO>> getBasicPeliculas(){
        List<PeliculaBasicDTO> peliculaBasicList = peliculaService.getBasicPeliculas();
        return ResponseEntity.ok().body(peliculaBasicList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePelicula(@PathVariable Long id){
        peliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update(@PathVariable Long id,@RequestBody PeliculaDTO peliculaDTO){
        PeliculaDTO peliculaUpdate = peliculaService.update(id,peliculaDTO);
        return ResponseEntity.ok().body(peliculaUpdate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> findById(@PathVariable Long id){
        PeliculaDTO peliculaFind = peliculaService.findById(id);
        return ResponseEntity.ok().body(peliculaFind);
    }

    @GetMapping("/filters")
    public ResponseEntity<List<PeliculaDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false,defaultValue = "ASC") String order
    ){
        List<PeliculaDTO> peliculas = peliculaService.getByFilters(name,genre,order);
        return ResponseEntity.ok(peliculas);
    }

}
