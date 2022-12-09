package com.segundo.pruebados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segundo.pruebados.InterfaceService.IDetalleDeudaService;
import com.segundo.pruebados.model.DetalleDeuda;

@RestController
@RequestMapping("/detalle-deuda")
public class DetalleDeudaController {
    @Autowired
    private IDetalleDeudaService service;
    
    @PostMapping(value = "/crear", consumes = {"application/json"}) 
    public ResponseEntity<DetalleDeuda> createPersona(@RequestBody DetalleDeuda detalleDeuda) {
         return service.create(detalleDeuda);
    }

    @GetMapping(value = "/detalle-id/{id}")
    public ResponseEntity<List<DetalleDeuda>> getDeuda(@PathVariable("id") int id){
        return service.getDetalles(id);
    }
}
