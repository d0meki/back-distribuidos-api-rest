package com.segundo.pruebados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segundo.pruebados.InterfaceService.IDeudaService;
import com.segundo.pruebados.model.Deuda;

@RestController
@RequestMapping("/deuda")
public class DeudaController {
    @Autowired
    private IDeudaService service;
    
    @PostMapping(value = "/creardeuda", consumes = {"application/json"}) 
    public ResponseEntity<Deuda> createPersona(@RequestBody Deuda deuda) {
         return service.create(deuda);
    }

}
