package com.segundo.pruebados.InterfaceService;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.Persona;

public interface IPersonaService {
    public List<Persona> listar();
    public Optional<Persona> getPersonaId(int id);
    public Persona create(Persona persona);
    public Optional<Persona> editar(int id,Persona persona);
    public ResponseEntity<HttpStatus> eliminar(int id);
}
