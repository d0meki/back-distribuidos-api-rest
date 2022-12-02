package com.segundo.pruebados.InterfaceService;

import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.Concepto;

public interface IConceptoService {
    public ResponseEntity<Concepto> create(Concepto concepto);
}
