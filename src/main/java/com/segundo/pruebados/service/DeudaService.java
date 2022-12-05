package com.segundo.pruebados.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IDeudaService;
import com.segundo.pruebados.Interfaces.IDeuda;
import com.segundo.pruebados.model.Deuda;

@Service
public class DeudaService implements IDeudaService {

    @Autowired
    private IDeuda data;
    @PersistenceContext
    private EntityManager em;

    @Override
    public ResponseEntity<Deuda> create(Deuda deuda) {
        try {
            return new ResponseEntity<Deuda>(data.save(deuda), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Optional<Deuda> editar(Deuda deuda) {
        Optional<Deuda> deudaId = data.findById(deuda.getId());
        Deuda _deuda = deudaId.get();
        _deuda.setPagado(deuda.isPagado());
        data.save(_deuda);
        return data.findById(deuda.getId());
    }

    @Override
    public List<Deuda> listar() {
        return (List<Deuda>) data.findAll();
    }

    @Override
    public ResponseEntity<List<Deuda>> buscar(int id) {
        try {
            List<Deuda> d = em.createNativeQuery("SELECT*FROM deudas WHERE deudas.persona_id = :id",Deuda.class)
            .setParameter("id", id)
            .getResultList();
            return new ResponseEntity<List<Deuda>>(d, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
