package com.segundo.pruebados.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IPersonaService;
import com.segundo.pruebados.Interfaces.IPersona;
import com.segundo.pruebados.model.Persona;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersona data;
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Persona> listar() {
        return (List<Persona>) data.findAll();
    }

    @Override
    public Persona create(Persona persona) {
        return data.save(persona);
    }

    @Override
    public Optional<Persona> editar(int id, Persona persona) {
        Optional<Persona> personaId = data.findById(id);
        Persona _persona = personaId.get();
        _persona.setName(persona.getName());
        _persona.setTelefono(persona.getTelefono());
        data.save(_persona);
        return data.findById(id);
    }
    @Override
    public Optional<Persona> getPersonaId(int id) {
        return data.findById(id);
    }

    @Override
    public ResponseEntity<HttpStatus> eliminar(int id) {
        try {
            data.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<List<Persona>> buscarPorCi(String ci) {
        try {
            List<Persona> p = em.createNativeQuery("SELECT*FROM persona WHERE persona.ci = :ci",Persona.class)
            .setParameter("ci", ci)
            .getResultList();
            
            return new ResponseEntity<List<Persona>>(p, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
