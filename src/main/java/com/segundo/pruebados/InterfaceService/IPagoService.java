package com.segundo.pruebados.InterfaceService;


import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.Pago;
import com.segundo.pruebados.model.PagoDeuda;

public interface IPagoService {
    public ResponseEntity<Pago> create(Pago pago);
    public ResponseEntity<Pago> getPago(int deuda_id);
    public ResponseEntity<PagoDeuda> getPagoName(int deuda_id);
}
