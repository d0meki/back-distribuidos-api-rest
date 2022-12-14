package com.segundo.pruebados.controller;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segundo.pruebados.InterfaceService.IDeudaService;
import com.segundo.pruebados.model.Deuda;
import com.segundo.pruebados.model.DeudaCi;

@RestController
@RequestMapping("/deuda")
public class DeudaController {
    @Autowired
    private IDeudaService service;
    
    @PostMapping(value = "/creardeuda", consumes = {"application/json"}) 
    public ResponseEntity<Deuda> createPersona(@RequestBody Deuda deuda) {
         return service.create(deuda);
    }
    @GetMapping("/listardeudas")
    public List<Deuda> getDeudas(){
        List<Deuda>deudas = service.listar();
        return deudas;
    }

    @GetMapping(value = "/mydeuda/{id}")
    public ResponseEntity<List<Deuda>> getDeuda(@PathVariable("id") int id){
        return service.buscar(id);
    }
    @GetMapping(value = "/mydeudaci/{id}")
    public ResponseEntity<List<DeudaCi>> getDeudaPorCi(@PathVariable("id") String id){
        return service.buscarCi(id);
    }
    @GetMapping(value = "/historial/{id}")
    public ResponseEntity<List<Deuda>> getDeudaPagada(@PathVariable("id") int id){
        return service.historial(id);
    }
    @GetMapping(value = "/historialci/{id}")
    public ResponseEntity<List<DeudaCi>> getHistorialCi(@PathVariable("id") String id){
        return service.historialCi(id);
    }
    
    
}
