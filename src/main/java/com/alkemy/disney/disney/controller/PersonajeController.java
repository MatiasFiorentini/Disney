package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.PersonajeBasicDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personajeDTO){
        PersonajeDTO personajeSaved = personajeService.save(personajeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeSaved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonajeDTO>> getAll(){
        List<PersonajeDTO> personajeList = personajeService.getAllPersonajes();
        return ResponseEntity.ok().body(personajeList);
    }

    @GetMapping("/characters")
    public ResponseEntity<List<PersonajeBasicDTO>> getBasicPersonajes(){
        List<PersonajeBasicDTO> personajeBasicList = personajeService.getBasicPersonajes();
        return ResponseEntity.ok().body(personajeBasicList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePersonaje(@PathVariable Long id){
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> update(@PathVariable Long id,@RequestBody PersonajeDTO personajeDTO){
        PersonajeDTO personajeUpdate = personajeService.update(id,personajeDTO);
        return ResponseEntity.ok().body(personajeUpdate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> findById(@PathVariable Long id){
        PersonajeDTO personajeFind = personajeService.findById(id);
        return ResponseEntity.ok().body(personajeFind);
    }


}
