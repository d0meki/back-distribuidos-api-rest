package com.segundo.pruebados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segundo.pruebados.InterfaceService.IDeudaService;
import com.segundo.pruebados.InterfaceService.IPagoService;
import com.segundo.pruebados.model.Pagar;
import com.segundo.pruebados.model.Pago;



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
        return pagoService.create(pagar.getPago(),pagar.getDeuda().getId());
    }

}
