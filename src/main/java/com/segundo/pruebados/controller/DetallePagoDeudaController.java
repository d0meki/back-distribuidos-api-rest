package com.segundo.pruebados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segundo.pruebados.InterfaceService.IDetallePagoDeudaService;
import com.segundo.pruebados.model.PagoDeuda;

@RestController
@RequestMapping("/detalle-pago-deuda")
public class DetallePagoDeudaController {
    @Autowired
    private IDetallePagoDeudaService service;
    
    @GetMapping(value = "/list") 
    public List<PagoDeuda> createPersona() {
         return service.getDetallePAgoDeda();
    }
}
