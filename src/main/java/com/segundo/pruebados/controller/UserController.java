package com.segundo.pruebados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segundo.pruebados.InterfaceService.IPersonaService;
import com.segundo.pruebados.model.Persona;

//import io.swagger.models.Model;

@RestController
@RequestMapping("/persona")
public class UserController {
    @Autowired
    private IPersonaService service;

    @GetMapping("/listarpersonas")
    public List<Persona> getPersonas(){
        List<Persona>personas = service.listar();
        return personas;
    }
    @GetMapping(value = "/persona/{id}")
    public ResponseEntity<Optional<Persona>> getPersona(@PathVariable("id") int id){
        Optional<Persona> personaId = service.getPersonaId(id);
        if (personaId.isPresent()) {
            return new ResponseEntity<Optional<Persona>>(personaId, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/persona-ci/{ci}")
    public ResponseEntity<List<Persona>> getPersonaCI(@PathVariable("ci") String ci){
        return this.service.buscarPorCi(ci);
    }
    @PostMapping(value = "/crearpersona", consumes = {"application/json"}) 
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
         Persona userCreated = service.create(persona);
         return new ResponseEntity<Persona>(userCreated, HttpStatus.CREATED);
    }
    @PutMapping(value = "/editarpersona/{id}", consumes = {"application/json"})
    public ResponseEntity<Optional<Persona>> editarPersona(@PathVariable("id") int id, @RequestBody Persona persona){
        Optional<Persona> personaId = service.editar(id,persona);
        if (personaId.isPresent()) {
            return new ResponseEntity<Optional<Persona>>(personaId, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/eliminarpersona/{id}")
    public ResponseEntity<HttpStatus> eliminarPersona(@PathVariable("id") int id){
        return service.eliminar(id);
    }
}
