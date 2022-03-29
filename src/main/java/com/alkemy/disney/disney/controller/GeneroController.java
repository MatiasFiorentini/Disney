package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO generoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(generoService.save(generoDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GeneroDTO>> getAll(){        ;
        return ResponseEntity.ok().body(generoService.getAllGeneros());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeGenero(@PathVariable Long id){
        generoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> update(@PathVariable Long id,@RequestBody GeneroDTO generoDTO){
        return ResponseEntity.ok().body(generoService.update(id,generoDTO));
    }

}
