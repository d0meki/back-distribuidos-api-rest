package com.segundo.pruebados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segundo.pruebados.InterfaceService.IDeudaService;
import com.segundo.pruebados.InterfaceService.IPagoService;
import com.segundo.pruebados.model.Pagar;
import com.segundo.pruebados.model.Pago;
import com.segundo.pruebados.model.PagoDeuda;



@RestController
@RequestMapping("/pago")
public class PagoController {
    
    @Autowired
    private IPagoService pagoService;
    @Autowired
    private IDeudaService deudaService;

    @PostMapping(value = "/crearpago", consumes = {"application/json"}) 
    public ResponseEntity<Pago> createPersona(@RequestBody Pagar pagar) {
       
        deudaService.editar(pagar.getDeuda());
        return pagoService.create(pagar.getPago());

    }
    @GetMapping(value = "/mypago/{id}")
    public ResponseEntity<Pago> getDeuda(@PathVariable("id") int id){
        return pagoService.getPago(id);
    }
    @GetMapping(value = "/mypagoname/{id}")
    public ResponseEntity<PagoDeuda> getPagoName(@PathVariable("id") int id){
        return pagoService.getPagoName(id);
    }

}
