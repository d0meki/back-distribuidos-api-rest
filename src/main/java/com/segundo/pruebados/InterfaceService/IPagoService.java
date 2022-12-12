package com.segundo.pruebados.InterfaceService;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.Pago;

public interface IPagoService {
    public ResponseEntity<Pago> create(Pago pago);
    public ResponseEntity<Pago> getPago(int deuda_id);
}
