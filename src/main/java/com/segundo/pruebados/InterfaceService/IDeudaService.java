package com.segundo.pruebados.InterfaceService;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.Deuda;

public interface IDeudaService {
    public ResponseEntity<Deuda> create(Deuda deuda);
    public Optional<Deuda> editar(Deuda deuda);
}
