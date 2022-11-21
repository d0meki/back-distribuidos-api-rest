package com.segundo.pruebados.InterfaceService;

import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.DetalleDeuda;

public interface IDetalleDeudaService {
    public ResponseEntity<DetalleDeuda> create(DetalleDeuda detalleDeuda);
}
