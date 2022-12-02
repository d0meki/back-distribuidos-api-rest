package com.segundo.pruebados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IConceptoService;
import com.segundo.pruebados.Interfaces.IConcepto;
import com.segundo.pruebados.model.Concepto;

@Service
public class ConceptoService implements IConceptoService{

    @Autowired
    private IConcepto data;

    @Override
    public ResponseEntity<Concepto> create(Concepto concepto) {
        try {
            return new ResponseEntity<Concepto>(data.save(concepto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
