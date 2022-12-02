package com.segundo.pruebados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segundo.pruebados.InterfaceService.IConceptoService;
import com.segundo.pruebados.model.Concepto;

@RestController
@RequestMapping("/concepto")
public class ConceptoController {
    
    @Autowired
    private IConceptoService service;

    @PostMapping(value = "/crearconcepto", consumes = {"application/json"}) 
    public ResponseEntity<Concepto> createPersona(@RequestBody Concepto concepto) {
         return service.create(concepto);
    }

}
