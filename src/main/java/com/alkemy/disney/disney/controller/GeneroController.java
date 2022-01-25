package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO generoDTO){
        GeneroDTO generoSaved = generoService.save(generoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoSaved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List<GeneroDTO> generoList = generoService.getAllGeneros();
        return ResponseEntity.ok().body(generoList);
    }
}
