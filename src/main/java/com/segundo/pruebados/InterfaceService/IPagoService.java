package com.segundo.pruebados.InterfaceService;

import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.Pago;

public interface IPagoService {
    public ResponseEntity<Pago> create(Pago pago,int id);
}
