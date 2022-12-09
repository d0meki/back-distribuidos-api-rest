package com.segundo.pruebados.InterfaceService;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.DetalleDeuda;

public interface IDetalleDeudaService {
    public ResponseEntity<DetalleDeuda> create(DetalleDeuda detalleDeuda);
    public ResponseEntity<List<DetalleDeuda>> getDetalles(int deuda_id);
}
